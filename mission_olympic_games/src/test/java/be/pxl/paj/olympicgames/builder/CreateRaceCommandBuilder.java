package be.pxl.paj.olympicgames.builder;

import be.pxl.paj.olympicgames.api.data.CreateRaceCommand;
import be.pxl.paj.olympicgames.domain.Discipline;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public final class CreateRaceCommandBuilder {
    public static final Discipline DISCIPLINE = Discipline.SPRINT_100M;
    private Discipline discipline = DISCIPLINE;
    private LocalDateTime dateTime;

    private CreateRaceCommandBuilder() {
    }

    public static CreateRaceCommandBuilder aCreateRaceCommand() {
        return new CreateRaceCommandBuilder();
    }

    public CreateRaceCommandBuilder withDiscipline(Discipline discipline) {
        this.discipline = discipline;
        return this;
    }

    public CreateRaceCommandBuilder withDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public CreateRaceCommand build() {
        CreateRaceCommand createRaceCommand = new CreateRaceCommand();
        createRaceCommand.setDiscipline(discipline);
        createRaceCommand.setDateTime(dateTime);
        return createRaceCommand;
    }
}
