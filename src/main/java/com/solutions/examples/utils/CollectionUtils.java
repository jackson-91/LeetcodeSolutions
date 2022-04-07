package com.solutions.examples.utils;

import java.util.*;

public class CollectionUtils {

    public final static String SEPERATOR_COMMA = ",";

    public final static String SEPERATOR_TAB = "\t";

    public final static String SEPERATOR_LINE = "\n";

    public static void printCollection(Collection<Object> objectCollection) {
        printCollection(objectCollection, SEPERATOR_LINE);
    }

    public static void printCollection(Collection<Object> objectCollection, String seperator) {
        String prefix = "";
        String suffix = "";
        if (!SEPERATOR_LINE.equals(seperator)) {
            prefix = "[";
            suffix = "]";
        }
        System.out.print(prefix);

        StringJoiner stringJoiner = new StringJoiner(seperator);
        for (Object object : objectCollection) {
            stringJoiner.add(object.toString()+seperator);
        }
        System.out.println(stringJoiner.toString());

        System.out.print(suffix);
    }

    public static void printMap(Map<Object, Object> objectMap) {
        printMap(objectMap, SEPERATOR_LINE);
    }

    public static void printMap(Map<Object, Object> objectMap, String seperator) {
        String prefix = "";
        String suffix = "";
        if (!SEPERATOR_LINE.equals(seperator)) {
            prefix = "[";
            suffix = "]";
        }
        System.out.print(prefix);

        StringJoiner stringJoiner = new StringJoiner(seperator);
        for (Map.Entry<Object, Object> entry : objectMap.entrySet()) {
            stringJoiner.add(entry.getKey().toString()+"<=>"+entry.getValue().toString());
        }
        System.out.println(stringJoiner.toString());


        System.out.print(suffix);
    }


}
