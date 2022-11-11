import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTime extends Planner implements Repeatability{
    public OneTime(String heading, String description, TaskType type, LocalDateTime creationTime, Replay replay)
            throws LineNotFilled {
        super(heading, description, type, creationTime, replay);
    }

    public boolean taskRepetitionRate(LocalDate localDate) {
            return getCreationTime().toLocalDate().isEqual(localDate);
    }
}
