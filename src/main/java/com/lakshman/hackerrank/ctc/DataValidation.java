package com.lakshman.hackerrank.ctc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataValidation {

    /**
     * Complete the validate function below.
     */
    static String validate(String input) {
        String result = "0:0:0:format_error";
        Map<String, List<String>> map = new HashMap<>();


        char[] inputCharArray = input.toCharArray();
        if (inputCharArray[0] != '|' || !(new String(inputCharArray, 1, 4).equals("name")) || inputCharArray[5] != '|') {
            return result;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 6; i < inputCharArray.length; i++) {
            if (inputCharArray[i] == '|') {
                break;
            }
            builder.append(inputCharArray[i]);
        }
        String fieldName = builder.toString();
        if (inputCharArray[6 + fieldName.length()] != '|') {
            return result;
        }

        int lineCount = 0;
        for (String line : input.split("~n")) {
            if (lineCount == 0) {
                continue;
            }


            if (inputCharArray[0] != '|')
                return result;

            StringBuilder builderInner = new StringBuilder();
            for (int i = 1; i < inputCharArray.length; i++) {
                if (inputCharArray[i] == '|') {
                    break;
                }
                builderInner.append(inputCharArray[i]);
            }

            builderInner.toString();
            for (char c : line.toCharArray()) {
                if (c == '|') continue;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        // return
        System.out.println(validate("|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n"));
    }

}
