package com.lakshman.patterns;

import java.util.Scanner;

/**
 * Created by Lakshman on 31-10-2017.
 *
 *  program to print below pattern
 *
 *  *
 *  * *
 *  * * *
 *  * * * *
 */
public class BasicTrianglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();

        printTriangle(numberOfLines);
        printTriangleSingleLoop(numberOfLines);

    }

    /**
     *
     * Prints like below if i/o 9
         0
         12
         345
         6789
     * @param n c
     */
    private static void printTriangleSingleLoop(int n) {
        int lineCount = 1;
        int currentLc = 0;

        for(int i = 1 ; i <= n ; i++){
            System.out.print(i);
            currentLc++;

            if(lineCount == currentLc){
                System.out.println();
                currentLc = 0;
                lineCount++;
            }
        }
    }


    private static void printTriangle(int n) {
        for(int i = 0; i <= n ; i++){
            for(int j = 0; j<= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
