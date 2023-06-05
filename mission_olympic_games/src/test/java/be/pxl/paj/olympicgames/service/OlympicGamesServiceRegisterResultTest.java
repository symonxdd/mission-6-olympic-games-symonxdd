package be.pxl.paj.olympicgames.service;

import be.pxl.paj.olympicgames.domain.Athlete;
import be.pxl.paj.olympicgames.domain.Race;
import be.pxl.paj.olympicgames.exception.BusinessException;
import be.pxl.paj.olympicgames.exception.NotFoundException;
import be.pxl.paj.olympicgames.repository.AthleteRepository;
import be.pxl.paj.olympicgames.repository.RaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static be.pxl.paj.olympicgames.builder.AthleteBuilder.anAthlete;
import static be.pxl.paj.olympicgames.builder.CreateRaceCommandBuilder.aCreateRaceCommand;
import static be.pxl.paj.olympicgames.builder.RaceBuilder.aRace;
import static be.pxl.paj.olympicgames.builder.RegisterScoreCommandBuilder.aRegisterScoreCommand;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OlympicGamesServiceRegisterResultTest {

    private static final Long RACE_ID = 7L;
    private static final Long ATHLETE_ID = 69L;

    @Mock
    private RaceRepository raceRepository;

    @Mock
    AthleteRepository athleteRepository;

    @InjectMocks
    OlympicGamesService olympicGamesService;

    @Test
    void throwsNotFoundExceptionWhenThereIsNoRaceWithGivenId() {
        when(raceRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        NotFoundException ex =
                assertThrows(NotFoundException.class, () -> olympicGamesService.registerResult(RACE_ID, ATHLETE_ID, aRegisterScoreCommand().build()));
        assertEquals("No race with id [" + RACE_ID + "]", ex.getMessage());
    }

    @Test
    void throwsNotFoundExceptionWhenThereIsNoAthleteWithGivenId() {
        when(raceRepository.findById(any(Long.class))).thenReturn(Optional.of(aRace().build()));
        when(athleteRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        NotFoundException ex =
                assertThrows(NotFoundException.class, () -> olympicGamesService.registerResult(RACE_ID, ATHLETE_ID, aRegisterScoreCommand().build()));
        assertEquals("No athlete with id [" + ATHLETE_ID + "]", ex.getMessage());
    }

    @Test
    void throwsBusinessExceptionWhenAthleteNotEnrolledInRace() {
        when(raceRepository.findById(any(Long.class))).thenReturn(Optional.of(aRace().build()));
        when(athleteRepository.findById(any(Long.class))).thenReturn(Optional.of(anAthlete().build()));
        BusinessException ex =
                assertThrows(BusinessException.class, () -> olympicGamesService.registerResult(RACE_ID, ATHLETE_ID, aRegisterScoreCommand().build()));
        assertEquals("Athlete [" + ATHLETE_ID + "] did not enroll in race.", ex.getMessage());
    }

    @Test
    void setScoreTimeWhenTimeIsProvided() {
        // TODO: check nog eventueel na 😀

        when(raceRepository.findById(any(Long.class))).thenReturn(Optional.of(aRace().build()));
        when(athleteRepository.findById(any(Long.class))).thenReturn(Optional.of(anAthlete().build()));
        BusinessException ex =
                assertThrows(BusinessException.class, () -> olympicGamesService.registerResult(RACE_ID, ATHLETE_ID, aRegisterScoreCommand().build()));
        assertEquals("Athlete [" + ATHLETE_ID + "] did not enroll in race.", ex.getMessage());
    }
}
