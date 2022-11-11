import java.time.LocalDate;
import java.time.LocalDateTime;

public class Weekly extends Planner implements Repeatability{
    public Weekly(String heading, String description, TaskType type, LocalDateTime creationTime, Replay replay)
            throws LineNotFilled {
        super(heading, description, type, creationTime, replay);
    }
    public boolean taskRepetitionRate(LocalDate localDate) {
        LocalDateTime creationTime;
            return getCreationTime().toLocalDate().isEqual(localDate);
    }
}
