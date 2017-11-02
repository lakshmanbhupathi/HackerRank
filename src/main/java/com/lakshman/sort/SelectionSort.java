package com.lakshman.sort;

import java.util.Arrays;

/**
 * Created by Lakshman on 02-11-2017.
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{6,4,3,5,2,1,9,7,8})));
    }

    /**
     * Little better than bubble sort as it only swaps once in iteration
     *
     * lesser swap but still O(n^2)
     *
     * @param array a
     * @return a
     */
    private static int[] selectionSort(int[] array) {

        int currentMin;
        int currMinIndex=0,temp;

        for(int i = 0; i<array.length ; i++){
            currentMin = array[i];
            for(int j = i+1; j<array.length; j++){
                if(currentMin<array[j]){
                    currentMin = array[j];
                    currMinIndex = j;
                }
            }
            if(array[i] != currentMin){
                temp=array[i];
                array[i]=array[currMinIndex];
                array[currMinIndex]=temp;
            }
        }

        return array;
    }

}
