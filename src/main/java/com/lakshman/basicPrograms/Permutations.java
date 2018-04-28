package com.lakshman.basicPrograms;


import java.util.concurrent.atomic.AtomicLong;

/**
 * Print or return all combinations of String passed
 *
 * @see <a href="http://javarevisited.blogspot.in/2015/08/how-to-find-all-permutations-of-string-java-example.html">find-all-permutations</a>
 */
public class Permutations {
    static AtomicLong coounter = new AtomicLong(0);

    public static void permutations(String string) {
        permutations("", string);
    }

    /**
     * find and prints all permutations
     *
     * @param perm perm string which need to be constant
     * @param string string which changes
     */
    private static void permutations(String perm, String string) {

        // base recursive statement
        if (string.isEmpty()) {
            coounter.incrementAndGet();
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            permutations(perm + string.charAt(i), string.substring(0, i) + string.substring(i + 1, string.length()));
        }
    }

    public static void main(String[] args) {
//        permutations("1234567890");
        permutations("GOD");
        System.out.println(coounter);
    }

}
