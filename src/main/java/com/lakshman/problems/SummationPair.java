package com.lakshman.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Asked Morgan stanley June'18
 * Asked Mojo Networks June'18
 *
 */
public class SummationPair {
    private static List<Integer> list = Arrays.asList(1,2,3,4,5);

    public static void main(String[] args) {
        int key = 10;

        System.out.println("Should be false :"+isSummationPresent(list,key));
        System.out.println("Should be false :"+isSummationPresent(list,60));
        System.out.println("Should be false :"+isSummationPresent(list,1));
        System.out.println("Should be true :"+isSummationPresent(list,6));
    }

    private static boolean isSummationPresent(List<Integer> list, int key) {
        Set<Integer> set = new HashSet<>(list);

        for (int currentValue : list){
            final int requiredValue = key - currentValue;
            if(requiredValue == currentValue) continue;
            if(set.contains(requiredValue)){
                return true;
            }
        }

        return false;
    }

    @Test
    public void test(){
        Assert.assertEquals(false,isSummationPresent(list,60));
        Assert.assertEquals(false,isSummationPresent(list,10));
        Assert.assertEquals(false,isSummationPresent(list,1));
        Assert.assertEquals(false,isSummationPresent(list,0));
        Assert.assertEquals(true,isSummationPresent(list,6));
        Assert.assertEquals(true,isSummationPresent(list,5));
        Assert.assertEquals(true,isSummationPresent(list,9));
    }

}
