package com.lakshman.basicPrograms.patterns;


/**
 * Reverse String
 */
public class ReverseString {

    /**
     * one approach use StringBuilder API
     *
     * @return
     */
    public static String reverseString(String string){
        return new StringBuilder(string).reverse().toString();
    }

}
