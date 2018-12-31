package week3.Intercom;

public class ActivateEnter {
    private static final int DURATION = 5000;
    private static long activatedAt = Long.MAX_VALUE;

    public static void activate() {
        activatedAt = System.currentTimeMillis();
    }

    public static boolean isActive() {
        long activeFor = System.currentTimeMillis() - activatedAt;
        return activeFor >= 0 && activeFor <= DURATION;
    }
}
