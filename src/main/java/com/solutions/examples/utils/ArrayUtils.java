package com.solutions.examples.utils;

public class ArrayUtils {

    public final static String SEPERATOR_COMMA = ",";

    public final static String SEPERATOR_TAB = "\t";

    public final static String SEPERATOR_LINE = "\n";

    public static void printArrays(Object[] objectArray) {
        printArrays(objectArray, SEPERATOR_LINE);
    }

    public static void printArrays(Object[] objectArray, String seperator) {
        for (Object object : objectArray) {
            System.out.print(object.toString()+seperator);
        }
    }

}
