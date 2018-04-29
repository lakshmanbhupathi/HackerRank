package com.lakshman.problems;

/**
 * Where n is a positive integer, the function  satisfies the following.
 * Please create a program to find . (You can write in any language that you are good at.)
 *
 * LINE Pretest April'18
 */
public class FibonacciSequence {

    /**
     * Fibonacci recursive
     *
     */
    public static int fibonacciSequence(int number){

        // base recursive condition
        if(number == 0 || number == 1) {
            return number;
        }

        return fibonacciSequence(number-1) + fibonacciSequence( number -2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciSequence(8080));
    }

}

