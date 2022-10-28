import java.time.LocalDateTime;

public class Planner implements Repeatability{
    private String heading;
    private String description;
    private TaskType type;
    private LocalDateTime creationTime;
    int id;
    private static int counterId=0;

    public Planner(String heading, String description, TaskType type, LocalDateTime creationTime, int id) {
        this.heading = heading;
        this.description = description;
        this.type = type;
        this.creationTime = creationTime;
        this.id = counterId++;
    }

    public Planner(String taskName, String taskDescription, TaskType type, LocalDateTime dateTime) {

    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) throws LineNotFilled{
        if (heading==null || description.isBlank()){
            throw new LineNotFilled("Введите заголовок");
        }else {
        this.heading = heading;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws LineNotFilled{
        if (description==null || description.isBlank()){
             throw new LineNotFilled("Введите описание");
        }else {
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

    @Override
    public void getOneTime() {
        System.out.println(Repeatability.ONE_TIME+"Однократно");
    }

    @Override
    public void getDaily() {
        System.out.println("Ежедневно");
    }

    @Override
    public void getWeekly() {
        System.out.println("Еженедельно");
    }

    @Override
    public void getMonthly() {
        System.out.println("Ежемесячно");
    }

    @Override
    public void getAnnual() {
        System.out.println("Ежегодно");
    }
}
