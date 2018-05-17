package com.lakshman.hackerrank.ctc;


/**
 * Convert base 10 to base 7
 *
 * as per given below table
 *
 * '0', 'a', 't', 'l', 's', 'i', 'n'
 *  0    1     2    3   4    5    6
 *
 */
public class BaseConversion {

    static String convert(long input) {
        char[] codes = new char[]{'0', 'a', 't', 'l', 's', 'i', 'n'};
        StringBuilder output = new StringBuilder();

        while (input > 0) {
            output.append(codes[(int)input % 7]);
            input = input / 7;
        }

        return output.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(779087123));
    }

}
