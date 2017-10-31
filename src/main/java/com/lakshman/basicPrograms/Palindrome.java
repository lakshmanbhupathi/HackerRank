package com.lakshman.basicPrograms;

/**
 * Created by Lakshman on 31-10-2017.
 *
 * TODO mathematical
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(11322));//false
    }

    private static boolean isPalindrome(int i) {
        return Integer.toString(i).equals(new StringBuilder(Integer.toString(i)).reverse().toString());
    }
}
