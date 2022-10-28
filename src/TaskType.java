public enum TaskType {
    P ("Личная"),
    W ("Рабочая");
    public final String type;

    TaskType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
