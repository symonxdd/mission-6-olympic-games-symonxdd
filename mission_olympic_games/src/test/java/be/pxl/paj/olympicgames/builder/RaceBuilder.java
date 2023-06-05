package be.pxl.paj.olympicgames.builder;

import be.pxl.paj.olympicgames.domain.Discipline;
import be.pxl.paj.olympicgames.domain.Race;

import java.time.LocalDateTime;

public final class RaceBuilder {
    public static final LocalDateTime DATE_TIME = LocalDateTime.of(1969, 1, 29, 7, 15);
    public static final Discipline DISCIPLINE = Discipline.SPRINT_100M;
    private LocalDateTime dateTime = DATE_TIME;
    private Discipline discipline = DISCIPLINE;

    private RaceBuilder() {
    }

    public static RaceBuilder aRace() {
        return new RaceBuilder();
    }

    public RaceBuilder withDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public RaceBuilder withDiscipline(Discipline discipline) {
        this.discipline = discipline;
        return this;
    }

    public Race build() {
        Race race = new Race();
        race.setDateTime(dateTime);
        race.setDiscipline(discipline);
        return race;
    }
}
