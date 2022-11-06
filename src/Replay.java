public enum Replay {
    EMPTY(0),
    ONE_TIME(1),
    DAILY(2),
    WEEKLY(3),
    MONTHLY(4),
    ANNUAL(5);

    private final int replay;


    Replay(int replay) {
        this.replay = replay;
    }

    public int getReplay() {
        return replay;
    }

    public static Replay getReplay(int i) {
        return values()[i];
    }
}
