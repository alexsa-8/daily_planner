import java.util.LinkedHashMap;
import java.util.Map;

public class TaskList {
    private final Map<Integer, Planner> taskMap;

    public TaskList() {
        this.taskMap = new LinkedHashMap<>();
    }
    public void addTask(Planner planner) throws LineNotFilled{
        if(taskMap.containsKey(planner.getId())){
            throw new RuntimeException("Введённая задача уже существует");
        }else {
            taskMap.put(planner.getId(), planner);
        }
    }
    public void removeTask(int id){
        taskMap.remove(id);
    }
    public void listOfTasks(){
        for (Map.Entry<Integer, Planner> planner : taskMap.entrySet()) {
            System.out.println(planner);
        }
    }
}
