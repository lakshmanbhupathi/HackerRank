package com.lakshman.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Codility Test
 *
 * @asked Zemoso June'18
 */
public class PhoneNumberReformat {

    @Test
    public void test(){
        Assert.assertEquals("004-448-555-583-61",solution("00-44  48 5555 8361"));
        Assert.assertEquals("022-198-53-24",solution("0 - 22 1985--324"));
        Assert.assertEquals("555-372-654",solution("555372654"));
    }

    public String solution(String S) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>(S.length());

        for (char c : S.toCharArray()) {
            try {
                Integer i = Integer.parseInt(c + "");
                queue.addLast(i);
            }catch (Exception e){
                continue;
            }
        }

        int currentCounter = 0;
        while (!queue.isEmpty()){
            if(queue.size() == 4 && currentCounter == 0){
                sb.append(queue.removeFirst());
                sb.append(queue.removeFirst());
                sb.append("-");

            } if(queue.size() == 2 && currentCounter == 0){
                sb.append(queue.removeFirst());
                sb.append(queue.removeFirst());
            } else{
                sb.append(queue.removeFirst());
                currentCounter++;

                if (currentCounter==3 && !queue.isEmpty()){
                    sb.append("-");
                    currentCounter=0;
                }
            }
        }

        return sb.toString();
    }
}
