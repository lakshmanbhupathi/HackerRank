package com.lakshman.problems;

import java.util.Arrays;
import java.util.TreeMap;

public class Romanizer {

    static String[] romanizer(int[] numbers) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        String results[] = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {

            int number = numbers[i];
            results[i] = toRoman(number, map);
        }

        return results;


    }

    public static String toRoman(int number, TreeMap<Integer, String> map) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l, map);
    }

    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 49, 50, 70, 69, 90, 99, 100, 499, 500, 999, 1000, 1234};
        System.out.println(Arrays.asList(romanizer(array)));
    }

}
