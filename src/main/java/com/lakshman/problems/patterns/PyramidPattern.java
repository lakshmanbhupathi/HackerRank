package com.lakshman.problems.patterns;

/**
 * Created by Lakshman on 31-10-2017.
 */
public class PyramidPattern {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int numberOfLines = scanner.nextInt();

        printPyramid(10);
        printPyramid(40);

    }

    private static void printPyramid(int numberOfLines) {
        for (int i = 0; i <= numberOfLines; i++){

            // Logic for inner spaces n-i
            for(int j = 0 ; j <= (numberOfLines - i)/2 ; j++){
                System.out.print(" ");
            }

            for (int k = 0 ; k <= i ; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
