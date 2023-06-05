package be.pxl.paj.olympicgames.api;

import be.pxl.paj.olympicgames.api.data.AthleteDTO;
import be.pxl.paj.olympicgames.api.data.CreateRaceCommand;
import be.pxl.paj.olympicgames.api.data.RaceDTO;
import be.pxl.paj.olympicgames.api.data.RegisterScoreCommand;
import be.pxl.paj.olympicgames.service.OlympicGamesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("olympicgames")
public class OlympicGamesController {

    private final OlympicGamesService olympicGamesService;

    public OlympicGamesController(OlympicGamesService olympicGamesService) {
        this.olympicGamesService = olympicGamesService;
    }

    @GetMapping("/athletes")
    public List<AthleteDTO> getAthletes() {
        return olympicGamesService.getAthletes();
    }

    @PostMapping("/races")
    public ResponseEntity<RaceDTO> createRace(@RequestBody @Valid CreateRaceCommand createRaceCommand) {
        return new ResponseEntity<>(olympicGamesService.createRace(createRaceCommand), HttpStatus.OK);
    }

    @GetMapping("/races")
    public List<RaceDTO> getRaces() {
        return olympicGamesService.getRaces();
    }

    @PutMapping("/races/{raceId}/{athleteId}")
    public ResponseEntity<RaceDTO> addAthleteToRace(@PathVariable Long raceId, @PathVariable Long athleteId) {
        RaceDTO race = olympicGamesService.addAthleteToRace(raceId, athleteId);
        return new ResponseEntity<>(race, HttpStatus.CREATED);
    }

    @DeleteMapping("/races/{raceId}/{athleteId}")
    public ResponseEntity<RaceDTO> removeAthleteFromRace(@PathVariable Long raceId, @PathVariable Long athleteId) {
        RaceDTO race = olympicGamesService.removeAthleteFromRace(raceId, athleteId);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @PostMapping("/races/{raceId}/{athleteId}")
    public ResponseEntity<Void> registerResult(
            @PathVariable Long raceId,
            @PathVariable Long athleteId,
            @RequestBody @Valid RegisterScoreCommand registerScoreCommand) {
        olympicGamesService.registerResult(raceId, athleteId, registerScoreCommand);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
