public enum TaskType {
    EMPTY(0),
    PERSONAL(1),
    WORK(2);
    private final int taskType;

    TaskType(int taskType) {
        this.taskType = taskType;
    }

    public int getTaskType() {
        return taskType;
    }

    public static TaskType getEnumFromConstant(int i) {
        return values()[i];
    }
}
