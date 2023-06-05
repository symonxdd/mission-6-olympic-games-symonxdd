package be.pxl.paj.olympicgames.config;

import be.pxl.paj.olympicgames.api.data.RegisterScoreCommand;
import be.pxl.paj.olympicgames.domain.Athlete;
import be.pxl.paj.olympicgames.domain.Discipline;
import be.pxl.paj.olympicgames.domain.Race;
import be.pxl.paj.olympicgames.domain.ScoreStatus;
import be.pxl.paj.olympicgames.repository.AthleteRepository;
import be.pxl.paj.olympicgames.repository.RaceRepository;
import be.pxl.paj.olympicgames.service.OlympicGamesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Component
public class ImportData implements CommandLineRunner {

    private final Logger LOGGER = LogManager.getLogger(ImportData.class);

    private final OlympicGamesService olympicGamesService;
    private final AthleteRepository athleteRepository;
    private final RaceRepository raceRepository;

    public ImportData(OlympicGamesService olympicGamesService, AthleteRepository athleteRepository, RaceRepository raceRepository) {
        this.olympicGamesService = olympicGamesService;
        this.athleteRepository = athleteRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Importing testdata...");
        Long athleteId1 = athleteRepository.save(new Athlete("Darron", "Fahey", "SZ", LocalDate.of(1977, 4, 8), Discipline.SPRINT_100M)).getId();
        Long athleteId2 = athleteRepository.save(new Athlete("Ole", "Klein", "VG", LocalDate.of(1984, 10, 31), Discipline.SPRINT_100M)).getId();
        Long athleteId3 = athleteRepository.save(new Athlete("Toni", "Douglas", "HR", LocalDate.of(2003, 11, 23), Discipline.SPRINT_100M)).getId();
        Long athleteId4 = athleteRepository.save(new Athlete("Amina", "Stoltenberg", "LY", LocalDate.of(2004, 9, 18), Discipline.SPRINT_100M)).getId();
        athleteRepository.save(new Athlete("Burley", "Conn", "EE", LocalDate.of(1984, 6, 27), Discipline.SPRINT_100M));
        athleteRepository.save(new Athlete("Norris", "Turner", "VU", LocalDate.of(1992, 3, 24), Discipline.SPRINT_100M));
        athleteRepository.save(new Athlete("Hollis", "Koelpin", "BN", LocalDate.of(1986, 7, 18), Discipline.SPRINT_100M));
        athleteRepository.save(new Athlete("Einar", "Hauck", "GW", LocalDate.of(2007, 11, 26), Discipline.SPRINT_100M));
        athleteRepository.save(new Athlete("Bernita", "Hane", "TJ", LocalDate.of(2008, 3, 8), Discipline.SPRINT_100M));
        athleteRepository.save(new Athlete("Edwin", "Cartwright", "SD", LocalDate.of(1999, 8, 6), Discipline.SPRINT_100M));
        athleteRepository.save(new Athlete("Darrin", "Jakubowski", "BN", LocalDate.of(1983, 1, 1), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Alphonso", "Grady", "ZW", LocalDate.of(1994, 2, 20), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Leatha", "Hahn", "KG", LocalDate.of(2007, 8, 9), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Aniyah", "Crooks", "BO", LocalDate.of(1988, 7, 6), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Edwardo", "Wintheiser", "PW", LocalDate.of(1987, 2, 15), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Alberta", "Feil", "PY", LocalDate.of(1995, 11, 18), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Britney", "Feil", "BI", LocalDate.of(1994, 9, 18), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Rosina", "Wehner", "GH", LocalDate.of(1987, 3, 29), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Monserrat", "Hegmann", "SY", LocalDate.of(2006, 7, 26), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Logan", "Waelchi", "IN", LocalDate.of(1998, 7, 27), Discipline.HORDES_400M));
        athleteRepository.save(new Athlete("Adela", "Kihn", "FI", LocalDate.of(1985, 5, 6), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Dashawn", "Hagenes", "GR", LocalDate.of(1979, 5, 6), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Marlon", "Wolf", "EG", LocalDate.of(1990, 7, 7), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Geovanni", "Hane", "AM", LocalDate.of(1993, 10, 24), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Rafaela", "Gleason", "KZ", LocalDate.of(1980, 9, 28), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Viva", "Ledner", "ES", LocalDate.of(1984, 8, 4), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Jannie", "Hoppe", "ER", LocalDate.of(1976, 10, 25), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Mose", "Abbott", "PE", LocalDate.of(1989, 11, 29), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Deondre", "Carroll", "SY", LocalDate.of(1989, 2, 18), Discipline.LONGDISTANCE_10000M));
        athleteRepository.save(new Athlete("Libby", "Reichel", "CU", LocalDate.of(1995, 11, 25), Discipline.LONGDISTANCE_10000M));

        Long raceId1 = raceRepository.save(new Race(LocalDateTime.now(), Discipline.SPRINT_100M)).getId();
        Long raceId2 = raceRepository.save(new Race(LocalDateTime.now(), Discipline.HORDES_400M)).getId();
        Long raceId3 = raceRepository.save(new Race(LocalDateTime.now(), Discipline.LONGDISTANCE_10000M)).getId();

        olympicGamesService.addAthleteToRace(raceId1, athleteId1);
        olympicGamesService.addAthleteToRace(raceId1, athleteId2);
        olympicGamesService.addAthleteToRace(raceId1, athleteId3);
        olympicGamesService.addAthleteToRace(raceId1, athleteId4);

        RegisterScoreCommand registerScoreCommand1 = new RegisterScoreCommand(ScoreStatus.ENROLLED, LocalTime.now().plus(5, ChronoUnit.MINUTES));
        RegisterScoreCommand registerScoreCommand2 = new RegisterScoreCommand(ScoreStatus.DISQUALIFIED, LocalTime.now().plus(15, ChronoUnit.MINUTES));
        RegisterScoreCommand registerScoreCommand3 = new RegisterScoreCommand(ScoreStatus.DISQUALIFIED, LocalTime.now().plus(10, ChronoUnit.MINUTES));
        RegisterScoreCommand registerScoreCommand4 = new RegisterScoreCommand(ScoreStatus.QUALIFIED, LocalTime.now().plus(20, ChronoUnit.MINUTES));
        olympicGamesService.registerResult(raceId1, athleteId1, registerScoreCommand1);
        olympicGamesService.registerResult(raceId1, athleteId2, registerScoreCommand2);
        olympicGamesService.registerResult(raceId1, athleteId3, registerScoreCommand3);
        olympicGamesService.registerResult(raceId1, athleteId4, registerScoreCommand4);
    }
}

