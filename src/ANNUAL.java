import java.time.LocalDate;
import java.time.LocalDateTime;

public class ANNUAL extends Planner implements Repeatability{
    public ANNUAL(String heading, String description, TaskType type, LocalDateTime creationTime, Replay replay)
            throws LineNotFilled {
        super(heading, description, type, creationTime, replay);
    }
    public boolean taskRepetitionRate(LocalDate localDate) {
        LocalDateTime creationTime;
        if (replay == Replay.ANNUAL) {
            return getCreationTime().toLocalDate().isEqual(localDate);
        }
        return false;
    }
}
