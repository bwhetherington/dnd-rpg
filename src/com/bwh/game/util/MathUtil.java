package com.bwh.game.util;

import java.awt.*;
import java.util.Random;
import java.util.Arrays;

/**
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public final class MathUtil {
	private MathUtil() {}
	
    // Constants
    public static final Point ORIGIN = new Point(0, 0);

    private static final Random RANDOM = new Random();

    /**
     * Returns a random integer bounded by the specified min and max,
     * inclusive.
     * @param min The lower bound
     * @param max The upper bound
     * @return A random integer bounded by the min and max
     */
    public static int randomInt(int min, int max) {
        if (min == max) {
            return min;
        }
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static int min(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array length must not be 0");
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int max(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array length must not be 0");
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int rollD4() {
        return randomInt(1, 4);
    }

    public static int rollD6() {
        return randomInt(1, 6);
    }

    public static int rollD8() {
        return randomInt(1, 8);
    }

    public static int rollD10() {
        return randomInt(1, 10);
    }

    public static int rollD12() {
        return randomInt(1, 12);
    }

    public static int rollD20() {
        return randomInt(1, 20);
    }

    public static double mean(int[] data) {
        double sum = 0;
        for (int i : data) {
            sum += i;
        }
        return sum / data.length;
    }

    public static double stdDev(int[] data) {
        final double mean = mean(data);
        double sum = 0;
        for (int i : data) {
            final double diff = i - mean;
            sum += diff * diff;
        }
        return Math.sqrt(sum) / (data.length - 1);
    }



    private static double medianSrt(int[] data) {
        return (data[data.length / 2] + data[(data.length - 1) / 2]) / 2.0;
    }

    private static double firstQuartileSrt(int[] data) {
        return (data[data.length / 4] + data[(data.length - 1) / 4]) / 2.0;
    }

    private static double thirdQuartileSrt(int[] data) {
        return (data[data.length * 3 / 4] + data[(data.length - 1) * 3 / 4]) / 2.0;
    }

    public static void analyze(int[] data) {
        final int min = min(data);
        final int max = max(data);
        System.out.printf("Minimum: %d%nMaximum: %d%nRange: %d%n",
                min, max, max - min);

        final double mean = mean(data);
        System.out.printf("Mean: %f%n", mean);

        final double stdDev = stdDev(data);
        System.out.printf("Standard Deviation: %f%n", stdDev);

        final int[] sampleSrt = Arrays.copyOf(data, data.length);
        Arrays.sort(sampleSrt);

        final double firstQuartile = firstQuartileSrt(sampleSrt);
        final double median = medianSrt(sampleSrt);
        final double thirdQuartile = thirdQuartileSrt(sampleSrt);
        System.out.printf("First Quartile: %f%nMedian: %f%nThird Quartile: %f%n",
                firstQuartile, median, thirdQuartile);
    }
}
