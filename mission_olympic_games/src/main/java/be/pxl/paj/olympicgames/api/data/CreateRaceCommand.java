package be.pxl.paj.olympicgames.api.data;

import be.pxl.paj.olympicgames.domain.Discipline;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateRaceCommand {

	@NotNull
	private Discipline discipline;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;

	public CreateRaceCommand() {
	}

	public CreateRaceCommand(Discipline discipline, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
		this.discipline = discipline;
		this.dateTime = dateTime;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
