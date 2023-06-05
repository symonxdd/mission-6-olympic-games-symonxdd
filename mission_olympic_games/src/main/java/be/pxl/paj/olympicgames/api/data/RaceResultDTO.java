package be.pxl.paj.olympicgames.api.data;

import be.pxl.paj.olympicgames.domain.Score;
import be.pxl.paj.olympicgames.domain.ScoreStatus;

import java.time.LocalTime;

public class RaceResultDTO {

	private final String name;
	private final String country;
	private final LocalTime time;
	private final ScoreStatus status;

	public RaceResultDTO(Score score) {
		this.name = score.getAthlete().getName();
		this.country = score.getAthlete().getCountry();
		this.time = score.getTime();
		this.status = score.getScoreStatus();
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public LocalTime getTime() {
		return time;
	}

	public ScoreStatus getStatus() {
		return status;
	}
}
