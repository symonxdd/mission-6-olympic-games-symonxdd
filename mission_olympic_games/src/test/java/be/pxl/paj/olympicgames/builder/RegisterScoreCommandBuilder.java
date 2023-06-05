package be.pxl.paj.olympicgames.builder;

import be.pxl.paj.olympicgames.api.data.RegisterScoreCommand;
import be.pxl.paj.olympicgames.domain.ScoreStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public final class RegisterScoreCommandBuilder {
    public static final ScoreStatus SCORE_STATUS = ScoreStatus.ENROLLED;
    public static final LocalTime LOCAL_TIME = LocalTime.of(0, 0, 20);
    private ScoreStatus status = SCORE_STATUS;
    private LocalTime time = LOCAL_TIME;

    private RegisterScoreCommandBuilder() {
    }

    public static RegisterScoreCommandBuilder aRegisterScoreCommand() {
        return new RegisterScoreCommandBuilder();
    }

    public RegisterScoreCommandBuilder withStatus(ScoreStatus status) {
        this.status = status;
        return this;
    }

    public RegisterScoreCommandBuilder withTime(LocalTime time) {
        this.time = time;
        return this;
    }

    public RegisterScoreCommand build() {
        return new RegisterScoreCommand(status, time);
    }
}
