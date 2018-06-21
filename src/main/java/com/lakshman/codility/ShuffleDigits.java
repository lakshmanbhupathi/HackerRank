package com.lakshman.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * Shuffle the given digits alternatively one from front and one from end
 *
 * @asked Zelando June'18
 */
public class ShuffleDigits {
    @Test
    public void test() {
        Assert.assertEquals(162534,solution(123456));
        Assert.assertEquals(103,solution(130));
    }

    // TODO mathematical solution
    public int solution(int A) {
        char[] charArray = (A+"").toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = charArray.length -1 ; i < j ; ) {
            sb.append(charArray[i++]);
            sb.append(charArray[j--]);
            if(i == j){
                sb.append(charArray[i]);
            }
        }

        return Integer.parseInt(sb.toString());
    }

}
