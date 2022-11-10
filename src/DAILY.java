import java.time.LocalDate;
import java.time.LocalDateTime;

public class DAILY extends Planner implements Repeatability{
    public DAILY(String heading, String description, TaskType type, LocalDateTime creationTime, Replay replay)
            throws LineNotFilled {
        super(heading, description, type, creationTime, replay);
    }
    public boolean taskRepetitionRate(LocalDate localDate) {
        LocalDateTime creationTime;
        if (replay == Replay.DAILY) {
            return getCreationTime().toLocalDate().isBefore(localDate);
        }
        return false;
    }
}
