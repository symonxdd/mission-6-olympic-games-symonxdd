package be.pxl.paj.olympicgames.api.data;

import be.pxl.paj.olympicgames.domain.ScoreStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class RegisterScoreCommand {
    @NotNull
    private ScoreStatus status;
    @JsonFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime time;

    public RegisterScoreCommand() {
    }

    public RegisterScoreCommand(ScoreStatus status, @JsonFormat(pattern = "HH:mm:ss.SSS") LocalTime time) {
        this.status = status;
        this.time = time;
    }

    public ScoreStatus getStatus() {
        return status;
    }

    public LocalTime getTime() {
        return time;
    }
}
