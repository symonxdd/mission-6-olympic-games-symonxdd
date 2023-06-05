package be.pxl.paj.olympicgames.api.data;

import be.pxl.paj.olympicgames.domain.Race;
import be.pxl.paj.olympicgames.domain.Score;

import java.util.ArrayList;
import java.util.List;

public class RaceResultsDTO extends RaceDTO {

	private final List<RaceResultDTO> raceResults = new ArrayList<>();

	public RaceResultsDTO(Race race) {
		super(race);
		for (Score score : race.getScores()) {
			raceResults.add(new RaceResultDTO(score));
		}
	}

	public List<RaceResultDTO> getRaceResults() {
		return raceResults;
	}
}
