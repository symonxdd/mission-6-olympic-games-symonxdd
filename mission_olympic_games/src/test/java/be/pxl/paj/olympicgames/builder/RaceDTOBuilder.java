package be.pxl.paj.olympicgames.builder;

import be.pxl.paj.olympicgames.api.data.RaceDTO;
import be.pxl.paj.olympicgames.domain.Discipline;

import java.time.LocalDateTime;

public final class RaceDTOBuilder {
    public final static Long ID = 5L;
    public final static Discipline DISCIPLINE = Discipline.HORDES_400M;
    private long id = ID;
    private Discipline discipline = DISCIPLINE;
    private LocalDateTime dateTime;

    private RaceDTOBuilder() {
    }

    public static RaceDTOBuilder aRaceDTO() {
        return new RaceDTOBuilder();
    }

    public RaceDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public RaceDTOBuilder withDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public RaceDTOBuilder withDiscipline(Discipline discipline) {
        this.discipline = discipline;
        return this;
    }

    public RaceDTO build() {
        RaceDTO raceDTO = new RaceDTO();
        raceDTO.setId(id);
        raceDTO.setDateTime(dateTime);
        raceDTO.setDiscipline(discipline);
        return raceDTO;
    }
}
