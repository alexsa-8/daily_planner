import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Planner implements Repeatability {
    private String heading;
    private String description;
    private final TaskType type;
    private LocalDateTime creationTime;
    private final int id;
    private static int counterId = 0;
    private final Replay replay;

    public Planner(String heading, String description, TaskType type,
                   LocalDateTime creationTime, Replay replay) throws LineNotFilled {
        this.heading = heading;
        this.description = description;
        this.type = type;
        this.creationTime = creationTime;
        this.replay = replay;
        this.id = counterId++;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) throws LineNotFilled {
        if (heading == null || heading.isBlank()) {
            throw new LineNotFilled("Введите заголовок: ");
        } else {
            this.heading = heading;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws LineNotFilled {
        if (description == null || description.isBlank()) {
            throw new LineNotFilled("Введите описание: ");
        } else {
            this.description = description;
        }
    }

    public TaskType getType() {
        return type;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public int getId() {
        return id;
    }

    public static int getCounterId() {
        return counterId;
    }

    public Replay getReplay() {
        return replay;
    }

    public boolean time(LocalDate localDate) {
        switch (replay) {
            case ONE_TIME:
                return creationTime.toLocalDate().isEqual(localDate);
            case DAILY:
                return creationTime.toLocalDate().isBefore(localDate);
            case WEEKLY:
                while (creationTime.toLocalDate().isBefore(localDate) && !creationTime.toLocalDate().isEqual(localDate)) {
                    creationTime = creationTime.plusWeeks(1);
                }
                return creationTime.toLocalDate().isEqual(localDate);
            case MONTHLY:
                while (creationTime.toLocalDate().isBefore(localDate) && !creationTime.toLocalDate().isEqual(localDate)) {
                    creationTime = creationTime.plusMonths(1);
                }
                return creationTime.toLocalDate().isEqual(localDate);
            case ANNUAL:
                while (creationTime.toLocalDate().isBefore(localDate) && !creationTime.toLocalDate().isEqual(localDate)) {
                    creationTime = creationTime.plusYears(1);
                }
                return creationTime.toLocalDate().isEqual(localDate);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planner planner = (Planner) o;
        return id == planner.id && Objects.equals(heading, planner.heading) &&
                Objects.equals(description, planner.description) &&
                type == planner.type && Objects.equals(creationTime, planner.creationTime) &&
                replay == planner.replay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, description, type, creationTime, id, replay);
    }

    @Override
    public String toString() {
        return "Заголовок: " + heading +
                ", описание: " + description +
                ", тип задания: " + type +
                ", время: " + creationTime +
                ", id номер: " + id + ".";
    }
}
