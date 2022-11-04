import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LineNotFilled {
        TaskList planner = new TaskList();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, planner);
                            break;
                        case 2:
                            enterTaskId(scanner, planner);
                            break;
                        case 3:
                            listTasks(planner);
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

    private static void inputTask(Scanner scanner, TaskList planner) throws LineNotFilled {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Ведите опесание задачи: ");
        String taskDescription = scanner.next();
        System.out.println("Укажите тип задачи: ");
        System.out.println(
                """
                        1 - личная,
                        2 - рабочая.
                        """);
        TaskType type = TaskType.getEnumFromConstant(Integer.parseInt(scanner.next()));
        System.out.println("Введите год-месяц-число час:минуты: ");
        LocalDate date = LocalDate.parse(scanner.next());
        LocalTime time = LocalTime.parse(scanner.next());
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        planner.addTask(new Planner(taskName, taskDescription, type, dateTime));
        System.out.println("Выберете повторяемость: ");
        System.out.println(
                """
                        1. Однократно,
                        2. Ежедневно,
                        3. Еженедельно,
                        4. Ежемесячно,
                        5. Ежегодно.
                        """);
        int repeatability = scanner.nextInt();
        Repeatability repeatability1 = new Planner(taskName, taskDescription, type, dateTime);
        switch (repeatability) {
            case 1 -> repeatability1.getOneTime();
            case 2 -> repeatability1.getDaily();
            case 3 -> repeatability1.getWeekly();
            case 4 -> repeatability1.getMonthly();
            case 5 -> repeatability1.getAnnual();
        }
    }

    private static void enterTaskId(Scanner scanner, TaskList planner) {
        System.out.println("Введите номер ID: ");
        int id = scanner.nextInt();
        planner.removeTask(id);
    }

    private static void listTasks(TaskList planner) {
        System.out.println("Список задач на день: ");
        planner.listOfTasks();
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );

    }
}
