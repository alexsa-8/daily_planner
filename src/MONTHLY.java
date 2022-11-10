import java.time.LocalDate;
import java.time.LocalDateTime;

public class MONTHLY extends Planner implements Repeatability{
    public MONTHLY(String heading, String description, TaskType type, LocalDateTime creationTime, Replay replay)
            throws LineNotFilled {
        super(heading, description, type, creationTime, replay);
    }
    public boolean taskRepetitionRate(LocalDate localDate) {
        LocalDateTime creationTime;
        if (replay == Replay.MONTHLY) {
            return getCreationTime().toLocalDate().isEqual(localDate);
        }
        return false;
    }
}
