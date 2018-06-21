package com.lakshman.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * Determine maximum number of words in a sentence ,
 * where given input string can be divided into sentence by '.' '?' '!'
 * words can be divided by space ' '
 *
 * @asked Zelando June'18
 */
public class MaximumWordsInASentence {

    @Test
    public void test() {
        Assert.assertEquals(4, solution("We test coders. Give us a try?"));
        Assert.assertEquals(2, solution("Forget  CVs..Save time . x x"));
    }


    public int solution(String S) {
        int currentWordCount = 0;
        int maxWordCount = 0;
        for (char c : S.toCharArray()) {
            if (c == '.' || c == '?' || c == '!') {
                currentWordCount = 0;
            } else if (c == ' ') {
                currentWordCount++;
                if (maxWordCount < currentWordCount) {
                    maxWordCount = currentWordCount;
                }
            }
        }

        return maxWordCount;
    }

}
