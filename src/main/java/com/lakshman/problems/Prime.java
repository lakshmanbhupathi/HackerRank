package com.lakshman.problems;

import java.util.Scanner;

/**
 * Created by Lakshman on 31-10-2017.
 *
 * TODO print all prime number below given input
 */
public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.println(isPrime(input));
    }

    private static boolean isPrime(int input) {
        boolean result = true;

        for(int i = 2; i <= input / 2 ; i++){
            if(input % i == 0){
                result = false;
                break;
            }
        }

        return result;
    }


}
