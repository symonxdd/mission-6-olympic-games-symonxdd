package be.pxl.paj.olympicgames.api.data;

import be.pxl.paj.olympicgames.domain.Discipline;
import be.pxl.paj.olympicgames.domain.Race;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class RaceDTO {
	private long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dateTime;
	private Discipline discipline;

	public RaceDTO(Race race) {
		this.id = race.getId();
		this.dateTime = race.getDateTime();
		this.discipline = race.getDiscipline();
	}

	public RaceDTO() {
		// For builder
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
}
