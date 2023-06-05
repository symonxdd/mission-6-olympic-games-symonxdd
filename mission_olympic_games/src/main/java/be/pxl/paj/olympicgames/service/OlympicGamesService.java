package be.pxl.paj.olympicgames.service;

import be.pxl.paj.olympicgames.api.data.AthleteDTO;
import be.pxl.paj.olympicgames.api.data.CreateRaceCommand;
import be.pxl.paj.olympicgames.api.data.RaceDTO;
import be.pxl.paj.olympicgames.api.data.RaceResultsDTO;
import be.pxl.paj.olympicgames.api.data.RegisterScoreCommand;
import be.pxl.paj.olympicgames.domain.Athlete;
import be.pxl.paj.olympicgames.domain.Race;
import be.pxl.paj.olympicgames.domain.Score;
import be.pxl.paj.olympicgames.exception.BusinessException;
import be.pxl.paj.olympicgames.exception.NotFoundException;
import be.pxl.paj.olympicgames.repository.AthleteRepository;
import be.pxl.paj.olympicgames.repository.RaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OlympicGamesService {

    private final RaceRepository raceRepository;
    private final AthleteRepository athleteRepository;

    public OlympicGamesService(RaceRepository raceRepository, AthleteRepository athleteRepository) {
        this.raceRepository = raceRepository;
        this.athleteRepository = athleteRepository;
    }

    public List<AthleteDTO> getAthletes() {
        return athleteRepository.findAll().stream().map(AthleteDTO::new).collect(Collectors.toList());
    }

    public List<RaceDTO> getRaces() {
        return raceRepository.findAll().stream().map(RaceDTO::new).collect(Collectors.toList());
    }

    public RaceDTO createRace(CreateRaceCommand createRaceCommand) {
        Race race = new Race();
        race.setDiscipline(createRaceCommand.getDiscipline());
        race.setDateTime(createRaceCommand.getDateTime());
        return new RaceDTO(raceRepository.save(race));
    }

    @Transactional
    public RaceDTO addAthleteToRace(Long raceId, Long athleteId) {
        Race race = raceRepository.findById(raceId).orElseThrow(() -> new NotFoundException("Race with ID: " + raceId + "not found."));
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new NotFoundException("Athlete with ID: " + athleteId + "not found."));

        race.addParticipant(athlete);
        return new RaceDTO(race);
    }

    @Transactional(readOnly = true)
    public RaceDTO removeAthleteFromRace(Long raceId, Long athleteId) {
        Race race = raceRepository.findById(raceId).orElseThrow(() -> new NotFoundException("Race with ID: " + raceId + "not found."));
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new NotFoundException("Athlete with ID: " + athleteId + "not found."));

        race.removeParticipant(athlete);
        return new RaceDTO(race);
    }

    @Transactional
    public void registerResult(Long raceId, Long athleteId, RegisterScoreCommand registerScoreCommand) {
        Race race = raceRepository.findById(raceId).orElseThrow(() -> new NotFoundException("No race with id [" + raceId + "]"));
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new NotFoundException("No athlete with id [" + athleteId + "]"));
        Optional<Score> score = race.getScore(athlete);
        if (score.isEmpty()) {
            throw new BusinessException("Athlete [" + athleteId + "] did not enroll in race.");
        }
        if (registerScoreCommand.getTime() != null) {
            score.get().setTime(registerScoreCommand.getTime());
        } else {
            score.get().updateStatus(registerScoreCommand.getStatus());
        }
    }

    @Transactional(readOnly = true)
    public RaceResultsDTO getRaceById(Long raceId) {
        Optional<Race> raceById = raceRepository.findById(raceId);
        if (raceById.isEmpty()) {
            throw new NotFoundException("Race with id: " + raceId + " doesn't exist.");
        }
        return new RaceResultsDTO(raceById.get());
    }
}
