package be.pxl.paj.olympicgames.domain;

import be.pxl.paj.olympicgames.config.LocalTimeAttributeConverter;
import be.pxl.paj.olympicgames.exception.BusinessException;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Score {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Athlete athlete;
    @ManyToOne
    private Race race;
    // Onderstaande annotaties zorgen ervoor dat LocalTime als tekst wordt opgeslaan in de databank.
    // Verwijder de deze annotaties niet.
    // Je hebt geen extra annotaties nodig bij deze eigenschap.
    @Column(columnDefinition = "VARCHAR(12)")
    @Convert(converter = LocalTimeAttributeConverter.class)
    private LocalTime time;
    @Enumerated(value = EnumType.STRING)
    private ScoreStatus scoreStatus;

    public Score() {
        // JPA only
    }

    public Score(Athlete athlete, Race race) {
        this.athlete = athlete;
        this.race = race;
        this.scoreStatus = ScoreStatus.ENROLLED;
    }

    public long getId() {
        return id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public Race getRace() {
        return race;
    }

    public LocalTime getTime() {
        return time;
    }

    public void updateStatus(ScoreStatus scoreStatus) {
        if (this.scoreStatus != ScoreStatus.ENROLLED) {
            throw new BusinessException("Status already changed.");
        }
        this.scoreStatus = scoreStatus;
    }

    public void setTime(LocalTime time) {
        updateStatus(ScoreStatus.QUALIFIED);
        this.time = time;
    }

    public ScoreStatus getScoreStatus() {
        return scoreStatus;
    }
}
