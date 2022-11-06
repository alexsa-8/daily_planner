import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskList {          //Список задач
    private final Map<Integer, Planner> taskMap;

    public TaskList() {
        this.taskMap = new LinkedHashMap<>();
    }

    public void addTask(Planner planner) {
        if (taskMap.containsKey(planner.getId())) {
            throw new RuntimeException("Введённая задача уже существует");
        } else {
            taskMap.put(planner.getId(), planner);
        }
    }

    public void removeTask(int id) {
        taskMap.remove(id);
    }

    public void listOfTasks() {
        for (Map.Entry<Integer, Planner> planner : taskMap.entrySet()) {
            System.out.println(planner);
        }
    }

    public List<Planner> getTasks(LocalDate date) {
        List<Planner> list = new ArrayList<>();
        for (Integer integer : taskMap.keySet()) {
            if (taskMap.get(integer).time(date)) {
                list.add(taskMap.get(integer));
            }
        }
        return list;
    }

    public Map<Integer, Planner> getTaskMap() {
        return taskMap;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "taskMap=" + taskMap +
                '}';
    }
}
