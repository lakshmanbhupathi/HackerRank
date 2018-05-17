package com.lakshman.hackerrank.ctc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Look and say problem
 *
 * Implement a function that reads off the digits of the input:
 *
 * lookAndSay(1) = 11 because it reads off 'one 1'
 * lookAndSay(11) = 21 because it reads off 'two 1'
 * lookAndSay(21) = 1211 because it reads off 'one 2, one 1'
 * lookAndSay(digits, n) n times recursion of lookAndSay
 *
 * @asked Atlassian May'18 Hackerrank
 */
public class LookAndSayProblem {

    static String lookAndSay(String start, int n) {

        String value = start;
        for (int i = 0; i < n; i++) {
            value = lookAndSay(value);
        }

        return value;

    }

    static String lookAndSay(final String num) {
        if (num == null || num.isEmpty()) {
            return "";
        }
        int firstCharPos = 0;
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(firstCharPos) != num.charAt(i)) {
                String digitsFound = num.substring(firstCharPos, i);
                builder.append(digitsFound.length()).append(num.charAt(firstCharPos));
                firstCharPos = i;
            }
        }
        builder.append(num.substring(firstCharPos, num.length()).length()).append(num.charAt(firstCharPos));
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay("11"));
    }

    @Test
    public void testLookAndSay(){
        assertEquals(lookAndSay("11"),"21");
        assertEquals(lookAndSay("111221"),"312211");
    }


}
