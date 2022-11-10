import java.time.LocalDate;
import java.time.LocalDateTime;

public class WEEKLY extends Planner implements Repeatability{
    public WEEKLY(String heading, String description, TaskType type, LocalDateTime creationTime, Replay replay)
            throws LineNotFilled {
        super(heading, description, type, creationTime, replay);
    }
    public boolean taskRepetitionRate(LocalDate localDate) {
        LocalDateTime creationTime;
        if (replay == Replay.WEEKLY) {
            return getCreationTime().toLocalDate().isEqual(localDate);
        }
        return false;
    }
}
