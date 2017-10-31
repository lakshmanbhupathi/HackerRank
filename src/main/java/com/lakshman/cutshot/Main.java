package com.lakshman.cutshot;

import java.util.Scanner;

/**
 * Created by Lakshman on 27-10-2017.
 * TODO
 *
 * The Fibonacci numbers are the numbers in the following integer sequence.
 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 . . .

 Given a specific number in this series Fn, your program needs to find the sum of all the numbers in the Fibonacci series that are smaller or equal to that number.

 Input Format
 Your program will be provided a number in the Fibonacci series on STDIN.

 Constraints
 0<<Fn<100000

 Sample Input
 8

 Sample Output
 The output for above input (8) should be 0 + 1 + 1 + 2 + 3 + 5 + 8
 20
 */
public class Main {

    public static long solveProblem(int input) {
		int result = 0;

		result = fibanoci(input);
        return result;
    }

    private static int fibanoci(int n) {
        int f = 0;
        int s = 1;

        int currSum = 0;
        int resultSum = 0;
        for( int i = 2; i < n ;i ++){
//            System.out.println("f"+f+"ss);
            resultSum += s;
            if(s == n){
                break;
            }
            currSum = f + s;
            f = s;
            s = currSum;
        }

        return resultSum;
    }


//Sample code only. Feel free to change to accept the input described in the problem.

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int input = 0;

        if(in.hasNextInt()){
            input = in.nextInt();
        }
		/*Parse input here*/
        System.out.println("This is the output");
        System.out.println(solveProblem(input));
    }

}
