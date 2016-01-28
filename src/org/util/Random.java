package org.util;

public class Random {
    private static java.util.Random random = new java.util.Random();

    public static int nextInt(int min, int max) {
        if (min > max) {
            min = max - (min - max);
        }
        return random.nextInt(max - min) + min;
    }
}
