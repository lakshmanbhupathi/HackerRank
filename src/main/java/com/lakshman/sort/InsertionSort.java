package com.lakshman.sort;

import java.util.Arrays;

/**
 * Created by Lakshman on 02-11-2017.
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{5,1,2,3,6,9,8,7,4})));
    }

    private static int[] insertionSort(int[] array) {
        int key,temp;

        //*** loop 1 to array.length
        for(int i =1 ; i< array.length ; i++){
            key = array[i];

            // loop j from i-1 to 0
            for(int j = i-1; j >= 0 ; j--) {

                if(key < array[j]){

                    // *** swap j and j+1
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }
}
