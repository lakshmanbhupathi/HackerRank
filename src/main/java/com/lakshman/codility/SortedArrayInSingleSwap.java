package com.lakshman.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class SortedArrayInSingleSwap {

    @Test
    public void test() {
        Assert.assertEquals(true,solution(new int[]{1,5,3,3,7}));
        Assert.assertEquals(false,solution(new int[]{1,3,5,3,4}));
        Assert.assertEquals(true,solution(new int[]{1,3,5}));
    }

    public boolean solution(int[] A) {
        int unmatchedValues = 0;

        int[] copyOfA = Arrays.copyOf(A, A.length);
        Arrays.sort(copyOfA);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != copyOfA[i]) {
                unmatchedValues++;
                if (unmatchedValues > 2)
                    return false;
            }
        }

        return true;
    }
}
