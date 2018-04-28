package com.lakshman.basicPrograms.patterns;


import org.junit.Assert;
import org.junit.Test;

/**
 * Reverse String
 */
public class ReverseString {

    /**
     * one approach use StringBuilder API
     *
     * @return
     */
    public static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    /**
     * Recursive approach be careful with very long string may lead to StackOverflow error
     *
     * @param string
     * @return
     */
    public static String reverseStringRecursive(String string) {
        if (string.length() < 2) {
            return string;
        }
        return reverseStringRecursive(string.substring(1)) + string.charAt(0);
    }

    @Test
    public void testReverseStringRecursive() {
        Assert.assertEquals("mal", reverseStringRecursive("lam"));
        Assert.assertNotEquals("mal", reverseStringRecursive("lama"));

        Assert.assertEquals("mal", reverseString("lam"));
        Assert.assertNotEquals("mal", reverseString("lama"));
    }

}
