import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LineNotFilled {
        TaskList dailyPlanner = new TaskList();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, dailyPlanner);
                            break;
                        case 2:
                            deleteTaskId(scanner, dailyPlanner);
                            break;
                        case 3:
                            listTasks(dailyPlanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner, TaskList dailyPlanner) throws LineNotFilled {
        try {
            System.out.print("Введите название задачи: ");
            String heading = scanner.next();
            scanner.nextLine();
            System.out.print("Ведите опесание задачи: ");
            String description = scanner.nextLine();
            System.out.println("Укажите тип задачи: ");
            System.out.println(
                    """
                            1 - личная,
                            2 - рабочая.
                            """
            );
            int taskTypeNum = scanner.nextInt();
            TaskType.getType(taskTypeNum);
            System.out.println("Введите год-месяц-число час:минуты: ");
            LocalDate date = LocalDate.parse(scanner.next());
            LocalTime time = LocalTime.parse(scanner.next());
            LocalDateTime dateTime = LocalDateTime.of(date, time);
            System.out.println("Выберете повторяемость: ");
            System.out.println(
                    """
                            1 - однократно,
                            2 - ежедневно,
                            3 - еженедельно,
                            4 - ежемесячно,
                            5 - ежегодно.
                            """
            );
            int replay = scanner.nextInt();
            Replay.getReplay(replay);
            dailyPlanner.addTask(new Planner(heading, description, TaskType.getType(taskTypeNum),
                    dateTime, Replay.getReplay(replay)) {
                @Override
                public boolean taskRepetitionRate(LocalDate localDate) {
                    return false;
                }
            });
        } catch (LineNotFilled e) {
            System.out.println("Введите полную информацию");
            System.out.println(e.getMessage());
        }

    }

    private static void deleteTaskId(Scanner scanner, TaskList dailyPlanner) {
        try {
            System.out.println("Введите номер ID: ");
            int id = scanner.nextInt();
            dailyPlanner.removeTask(id);
        } catch (Exception e) {
            System.out.println("Не правельный номер ID.");
            System.out.println(e.getMessage());
        }

    }

    private static void listTasks(TaskList dailyPlanner) {
        System.out.println("Список задач на день: ");
        dailyPlanner.listOfTasks();
    }

    private static void listTasksDate(Scanner scanner, TaskList dailyPlanner) {
        System.out.println("Список задач на указаную дату: ");
        LocalDate localDate = LocalDate.parse(scanner.next());
        System.out.println(dailyPlanner.getTasks(localDate));
    }


    private static void printMenu() {
        System.out.println(
                """
                        1 - Добавить задачу
                        2 - Удалить задачу
                        3 - Получить задачу на указанный день
                        0 - Выход
                        """
        );

    }
}
