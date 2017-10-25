package com.lakshman.hackerrank.ctc;

/**
 * Created by Lakshman on 25-10-2017.
 */

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 *
 */
public class Anagram {

    /**
     * @param first
     * @param second
     * @return
     *
     * @author Durga
     */
    public static int numberNeeded(String first, String second) {
        int delCount = 0;
        int matchcount = 0;
        HashMap<Character, Integer> hashMap1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashMap2 = new HashMap<Character, Integer>();
        for (char character : first.toCharArray()) {
            hashMap1.put(character, hashMap1.get(character) + 1);
        }
        for (char character : second.toCharArray()) {
            hashMap2.put(character, hashMap2.get(character) + 1);
        }

        for (Entry<Character, Integer> ele : hashMap1.entrySet()) {
            if (hashMap2.containsKey(ele.getKey())) {
                if (hashMap2.get(ele.getKey()) == ele.getValue()) {
                    matchcount = matchcount + ele.getValue();
                } else {
                    int diff = hashMap2.get(ele.getKey()) - ele.getValue();
                }

            } else {
                delCount = delCount + ele.getValue();
            }
        }
        return 0;
    }

    /**
     * @param first
     * @param second
     * @return
     *
     * @author Lakshman
     */
    public static int numberOfDeletionsNeededToBeAnagram(String first, String second) {
        int result = 0;
        StringBuilder secondBuilder = new StringBuilder(second);
        StringBuilder commonBuilder = new StringBuilder();

        for (char c : first.toCharArray()) {
            int index = secondBuilder.indexOf(Character.toString(c));

            if (index != -1) {
                secondBuilder.deleteCharAt(index);
                commonBuilder.append(c);
            }
        }

        result += first.length() - commonBuilder.length();
        result += second.length() - commonBuilder.length();

        return result;
    }

    public static void main(String[] args) {
//		System.out.println(numberNeeded("abc", "bde"));
        System.out.println(numberOfDeletionsNeededToBeAnagram("abc","bde"));
        System.out.println(numberOfDeletionsNeededToBeAnagram("aaabc","aabde"));
    }
}