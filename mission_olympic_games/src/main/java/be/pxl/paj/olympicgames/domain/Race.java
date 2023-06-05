package be.pxl.paj.olympicgames.domain;

import be.pxl.paj.olympicgames.exception.BusinessException;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Race {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;
    @Enumerated(value = EnumType.STRING)
    private Discipline discipline;
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<Score> scores = new ArrayList<>();

    public Race() {
        // JPA only
    }

    public Race(LocalDateTime dateTime, Discipline discipline) {
        this.dateTime = dateTime;
        this.discipline = discipline;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Long getId() {
        return id;
    }

    public void addParticipant(Athlete athlete) {
        if (getScore(athlete).isEmpty()) {
            if (athlete.getDiscipline() != discipline) {
                throw new BusinessException("Athlete [" + athlete.getId() + " ] is not allowed to participate in race [" + id + "]");
            }
            scores.add(new Score(athlete, this));
        }
    }

    public void removeParticipant(Athlete athlete) {
        Optional<Score> toRemove = getScore(athlete);
        toRemove.ifPresent(score -> scores.remove(score));
    }

    public Optional<Score> getScore(Athlete athlete) {
        return scores.stream().filter(s -> s.getAthlete().equals(athlete)).findAny();
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
