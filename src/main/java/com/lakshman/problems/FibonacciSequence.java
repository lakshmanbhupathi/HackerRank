package com.lakshman.problems;

/**
 * Where n is a positive integer, the function  satisfies the following.
 * Please create a program to find . (You can write in any language that you are good at.)
 * <p>
 * LINE Pretest April'18
 */
public class FibonacciSequence {

    /**
     * Fibonacci recursive
     * <p>
     * Regular recursive approach won't scale on bigger number
     * for example 8181
     */
    public static int fibonacciSequence(int number) {

        // base recursive condition
        if (number == 0 || number == 1) {
            return number;
        }

        return fibonacciSequence(number - 1) + fibonacciSequence(number - 2);
    }

    /**
     * Using Dynamic programming
     *
     * by caching already find results
     */
    public static long fibonacciSequenceDP(int number) {
        return fibonacciSequence(number, new long[number + 1]);
    }

    private static long fibonacciSequence(int number, long[] cache) {
        // base recursive condition
        if (number == 0 || number == 1) {
            return number;
        }

        if (cache[number] == 0) {
            cache[number] = fibonacciSequence(number - 1, cache) + fibonacciSequence(number - 2, cache);
        }
        return cache[number];
    }


    public static void main(String[] args) {
        System.out.println(fibonacciSequenceDP(8181));
    }

}

