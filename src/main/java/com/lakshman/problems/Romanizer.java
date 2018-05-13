package com.lakshman.problems;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Coverts given arabic numbers into Roman numerical
 *
 * @asked transferwise hacker rank test May'18
 */
public class Romanizer {
    static TreeMap<Integer, String> map = new TreeMap<>();

    static {
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
    }

    static String[] romanizer(int[] numbers) {
        String results[] = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {

            int number = numbers[i];
            results[i] = toRoman(number);
        }

        return results;
    }

    public static String toRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }

    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 49, 50, 70, 69, 90, 99, 100, 499, 500, 999, 1000, 1234};
        System.out.println(Arrays.asList(romanizer(array)));
    }

}
