package com.lakshman.sort;

/**
 * Created by Lakshman on 31-10-2017.
 *
 * Basic sort O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] sortedArray = bubbleSort(new int[]{7,2,1,3,4,5,8,6,9});
        for(int i : sortedArray){
            System.out.print(i);
        }
    }

    private static int[] bubbleSort(int[] array) {
        for(int i = 0; i < array.length ; i++){
            for( int j = 0 ; j < array.length ; j++){
                if( array[j] > array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }
}
