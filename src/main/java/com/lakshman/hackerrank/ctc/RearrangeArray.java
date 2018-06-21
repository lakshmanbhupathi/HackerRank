package com.lakshman.hackerrank.ctc;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @asked Ezetap June'18
 */
public class RearrangeArray {
    public static void main(String[] args) {
        for (int i : reArrangeArray(new int[]{22, 1, 34, 22, 16}, 22)) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i : reArrangeArray(new int[]{3, 5, 3, 5, 5, 11, 5}, 5)) {
            System.out.print(" " + i);
        }


        // i/0 hacker rank
        /*Scanner s = new Scanner(System.in);
        int noOfTestCases = s.nextInt();


        for (int i = 0; i < noOfTestCases; i++) {
            int size = s.nextInt();
            int[] intArray = new int[size];
            for (int j = 0; j < size; j++) {
                intArray[j] = Integer.parseInt(s.next());
            }
            int x = s.nextInt();


            int fla = 1;
            for (int k : reArrangeArray(intArray, x)) {
                if(fla == 1){
                    System.out.print(k);
                    fla++;
                }else {
                    System.out.print(" " + k);
                }
            }
            System.out.println();
        }*/

    }

    private static int[] reArrangeArray(int[] array, int x) {
        Stack<Integer> stack = new Stack<>();

        for (int i : array) {
            if (i != x) {
                stack.push(i);
            }
        }

        for (int i = array.length - 1; i > -1; i--) {
            try {
                array[i] = stack.pop();
            } catch (EmptyStackException e) {
                array[i] = 1;
            }
        }

        return array;
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1 ,1 ,1 ,34, 16},reArrangeArray(new int[]{22,1 ,34, 22, 16},22));
        Assert.assertArrayEquals(new int[]{1 ,1 ,1 ,1,3,3, 11},reArrangeArray(new int[]{3, 5, 3, 5, 5, 11, 5},5));
        Assert.assertArrayEquals(new int[]{1 ,1 ,1 ,1,1,1, 11},reArrangeArray(new int[]{5, 5, 5, 5, 5, 11, 5},5));
        Assert.assertArrayEquals(new int[]{1 ,1 ,1 ,1,1,1, 1},reArrangeArray(new int[]{5, 5, 5, 5, 5, 5, 5},5));
    }
}
