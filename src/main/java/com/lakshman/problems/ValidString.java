package com.lakshman.problems;


import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Validate String by below rules
 * <pre>
 *  [[[]]]    valid
 *  ][][     not valid
 *  []][][    not valid
 *  []][      not valid
 *  [][]      valid
 * </pre>
 */
public class ValidString {

    /**
     * using stack
     * <p>
     * oracle april'18
     *
     * @param expr
     * @return bool
     */
    public static boolean isValid(String expr) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = expr.toCharArray();

        try {
            for (char c : charArray) {
                if (c == '[') {
                    stack.push(c);
                } else if (c == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        } catch (EmptyStackException e){
            return false;
        }

        return stack.isEmpty();

    }

    @Test
    public void testValidString(){
        Assert.assertTrue(isValid("[][]"));
        Assert.assertTrue(isValid("[[[]]]"));

        Assert.assertFalse(isValid("[]]["));
        Assert.assertFalse(isValid("[]][]["));
        Assert.assertFalse(isValid("][]["));
        Assert.assertFalse(isValid("["));
    }

}
