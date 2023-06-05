package be.pxl.paj.olympicgames.api.data;

import be.pxl.paj.olympicgames.domain.Athlete;

public class AthleteDTO {
	private final Long id;
	private final String firstName;
	private final String lastName;
	private final String country;
	private final int age;

	public AthleteDTO(Athlete athlete) {
		this.id = athlete.getId();
		this.firstName = athlete.getFirstName();
		this.age = athlete.getAge();
		this.country = athlete.getCountry();
		this.lastName = athlete.getLastName();
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCountry() {
		return country;
	}

	public int getAge() {
		return age;
	}
}
