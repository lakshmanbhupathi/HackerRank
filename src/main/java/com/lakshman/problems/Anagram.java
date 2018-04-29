package com.lakshman.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * basic two strings given verify they are anagram or not
 */
public class Anagram {

    /**
     * Easy approach by sorting both of them
     * <p>
     * Complexity: O(n log(n))
     *
     * @param word1
     * @param word2
     * @return
     */
    public static boolean isAnagram(String word1, String word2) {
        char[] word1Ar = word1.toCharArray();
        Arrays.sort(word1Ar);

        char[] word2Ar = word2.toCharArray();
        Arrays.sort(word2Ar);

        // single line Arrays api
//        return Arrays.equals(word1Ar, word2Ar);

        int i = 0;
        for (char c : word1Ar) {
            if (c != word2Ar[i++]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Another approach by using stringBuffer
     * <p>
     * Complexity: O(n)
     *
     * @param word1
     * @param word2
     * @return
     */
    public static boolean isAnagram2(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word2);

        for (char c : word1.toCharArray()) {
            int index = sb.indexOf("" + c);
            if (index != -1) {
                sb.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return sb.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("mal", "lam"));
        System.out.println(isAnagram("mal", "lan"));

        System.out.println(isAnagram2("mal", "lam"));
        System.out.println(isAnagram2("mal", "lan"));
    }

    @Test
    public void testAnagram(){
        Assert.assertFalse(isAnagram("mal", "lan"));
        Assert.assertFalse(isAnagram("mal", "lama"));
        Assert.assertTrue(isAnagram("mal", "lam"));
    }

    @Test
    public void testAnagram2(){
        Assert.assertFalse(isAnagram2("mal", "lan"));
        Assert.assertFalse(isAnagram2("mal", "lama"));
        Assert.assertTrue(isAnagram2("mal", "lam"));
    }

}
