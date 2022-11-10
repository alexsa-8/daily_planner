import java.time.LocalDate;
import java.time.LocalDateTime;

public class ONE_TIME extends Planner implements Repeatability{
    public ONE_TIME(String heading, String description, TaskType type, LocalDateTime creationTime, Replay replay)
            throws LineNotFilled {
        super(heading, description, type, creationTime, replay);
    }
    public boolean taskRepetitionRate(LocalDate localDate) {
        if (replay == Replay.ONE_TIME) {
            return getCreationTime().toLocalDate().isEqual(localDate);
        }
        return false;
    }
}
