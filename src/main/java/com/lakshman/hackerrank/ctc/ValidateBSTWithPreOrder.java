package com.lakshman.hackerrank.ctc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidateBSTWithPreOrder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        ArrayList<Boolean> booleanArrayList = new ArrayList<>();

        for (int i = 0; i < queries; i++) {
            int size = scanner.nextInt();

            List<Integer> listArr = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                String ipStr = scanner.next();
                listArr.add(Integer.parseInt(ipStr));
            }
            booleanArrayList.add(checkTree(listArr));

        }

        for (boolean b : booleanArrayList) {
            if (b) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
    }


    public static boolean checkTree(List<Integer> arr) {
        if (arr.size() == 1) {
            return true;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        Integer root = arr.get(0);
        int idx = 1;

        //adding left subtree nodes
        while (arr.get(idx) < root) {
            left.add(arr.get(idx++));

            if (idx >= arr.size())
                break;
        }

        //adding right subtree nodes
        if (!(idx >= arr.size()))
            while (arr.get(idx) > root) {
                right.add(arr.get(idx++));

                if (idx >= arr.size())
                    break;
            }

        if (left.size() + right.size() == arr.size() - 1) {
            if (left.size() == 0) {
                return checkTree(right);
            } else if (right.size() == 0) {
                return checkTree(left);
            } else {
                return checkTree(left) && checkTree(right);
            }
        } else {
            return false;
        }

    }

}
