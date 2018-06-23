package com.lakshman.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Asked Mojo Networks June'18
 *
 */
public class DifferencePair {
    private static List<Integer> list = Arrays.asList(1,2,3,4,5);

    public static void main(String[] args) {
        int key = 10;

        System.out.println("Should be false :"+ isDiffPairPresent(list,key));
        System.out.println("Should be false :"+ isDiffPairPresent(list,60));
        System.out.println("Should be false :"+ isDiffPairPresent(list,1));
        System.out.println("Should be true :"+ isDiffPairPresent(list,6));
    }

    private static boolean isDiffPairPresent(final List<Integer> list, final int key) {
        Set<Integer> set = new HashSet<>(list);

        for (int currentValue : list){
            final int requiredValue = key + currentValue;
            if(requiredValue == currentValue) continue;
            if(set.contains(requiredValue)){
                return true;
            }
        }

        return false;
    }

    @Test
    public void test(){
        Assert.assertEquals(false, isDiffPairPresent(list,60));
        Assert.assertEquals(false, isDiffPairPresent(list,10));
        Assert.assertEquals(false, isDiffPairPresent(list,1));
        Assert.assertEquals(false, isDiffPairPresent(list,0));
        Assert.assertEquals(true, isDiffPairPresent(list,6));
        Assert.assertEquals(true, isDiffPairPresent(list,5));
        Assert.assertEquals(true, isDiffPairPresent(list,9));
    }

}
