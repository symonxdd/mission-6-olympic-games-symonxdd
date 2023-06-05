package be.pxl.paj.olympicgames.builder;

import be.pxl.paj.olympicgames.domain.Athlete;
import be.pxl.paj.olympicgames.domain.Discipline;

import java.time.LocalDate;

public final class AthleteBuilder {
    public static final String FIRST_NAME = "Johnny";
    public static final String LAST_NAME = "Depp";
    private String firstName = FIRST_NAME;
    private String lastName = LAST_NAME;
    private String country;
    private LocalDate dateOfBirth;
    private Discipline discipline;

    private AthleteBuilder() {
    }

    public static AthleteBuilder anAthlete() {
        return new AthleteBuilder();
    }

    public AthleteBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AthleteBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AthleteBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AthleteBuilder withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public AthleteBuilder withDiscipline(Discipline discipline) {
        this.discipline = discipline;
        return this;
    }

    public Athlete build() {
        return new Athlete(firstName, lastName, country, dateOfBirth, discipline);
    }
}
