package com.mine.utility;

public class Utilities {

    public static double GetRandomNumber(double min, double max) {
        return Math.random()*(max-min+1)+min;
    }
}
