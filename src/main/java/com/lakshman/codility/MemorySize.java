package com.lakshman.codility;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lakshman on 17-10-2017.
 */
public class MemorySize {
    public static void main(String[] args) {
//        int[] A = {1,2,2,2,2,5,1};
//        int[] A = {-1,3,-4,5,1,-6,2,1};
//        int[] A = {2,2,0,2,2};

//        System.out.println(A.length);
//        System.out.println(findEqi(A));

//        int[] A = {1, 3, 6, 4, 1, 2};
//        int[] A = {1, 3, -3};
//        int[] A = {-1,-3};
//        System.out.println(findSmallestInt(A));

        System.out.println(solution("my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b"));

//        System.out.println(sumDist(A));

    }

    private static int sumDist(int[] A) {
        int[] totalSum = new int[A.length];
        for(int i = 0 ; i < A.length ; i++){
            totalSum[i] = A[i] - i;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i = 0; i < A.length ; i++){
            if(totalSum[i] > max){
                max = totalSum[i];
                maxIndex = i;
            }
        }

        return max;
    }

    public static String solution(String S) {
        StringBuilder result = new StringBuilder();

        Map<String,String> extensionMap = new HashMap<String,String>(){{
            put("mp3","music");
            put("flac","music");
            put("aac","music");

            put("jpg","image");
            put("bmp","image");
            put("gif","image");

            put("mp4","movie");
            put("avi","movie");
            put("mkv","movie");
        }};
        Map<String,Integer> counterResultMap = new HashMap<String,Integer>(){{
            put("music",0);
            put("movie",0);
            put("other",0);
            put("image",0);
        }};

        String files[] = S.split("\n");

        for(String file : files){
            String[] fileNameAndSize = file.split(" ");
            String fileName = fileNameAndSize[0];
            String fileFormat = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
            Integer fileSize = Integer.parseInt(fileNameAndSize[1].substring(0,fileNameAndSize[1].length()-1));

            String fileType = extensionMap.get(fileFormat);
            if(fileType != null){

                Integer totalFileTypeSize = counterResultMap.get(fileType);
                if( totalFileTypeSize == null ){
                    counterResultMap.put(fileType,fileSize);
                } else {
                    counterResultMap.put(fileType,totalFileTypeSize + fileSize);
                }
            } else {
                Integer totalFileTypeSizeOfOthers = counterResultMap.get("other");

                if( totalFileTypeSizeOfOthers == null ){
                    counterResultMap.put("other",fileSize);
                } else {
                    counterResultMap.put("other",totalFileTypeSizeOfOthers + fileSize);
                }
            }
        }

//        for( String key : counterResultMap.keySet() ){
//            result.append(key +" "+ counterResultMap.get(key) + "b\n");
//        }
        result.append("music "+ counterResultMap.get("music") + "b\n");
        result.append("images " + counterResultMap.get("image") + "b\n");
        result.append("movies " + counterResultMap.get("movie") + "b\n");
        result.append("other " + counterResultMap.get("other") + "b");

        return result.toString();
    }

    private static int findSmallestInt(int[] A) {
        int result = -1;
        BitSet bitSet = new BitSet(A.length+1);

        for(int i = 0 ; i < A.length ; i++){
            if(A[i] < 0)
                continue;

            bitSet.set(A[i],true);
        }

        for(int i = 1 ; i < A.length ; i++){

            if(!bitSet.get(i)){
                result = i;
                break;
            }
        }

        return result;
    }

    private static int findEqi(int[] a) {
        int result = -1;

        int postfixCount = 0;
        for(int i = 1; i < a.length ; i++){
            postfixCount += a[i];
        }

        int prefixCount = a[0];
        for(int i = 1; i < a.length ; i++ ){
            postfixCount -= a[i];
            if(prefixCount == postfixCount){
                result = i;
            }
            prefixCount += a[i];
        }

        return result;
    }

    private static int findLeader(int[] a) {
        int result = -1;
        Map<Integer,Integer> countMap = new HashMap<>(a.length);

        for(int currentNum : a){
            countMap.put(currentNum,  countMap.get(currentNum) == null ? 1 : countMap.get(currentNum) + 1);
        }


        for(int i : countMap.keySet() ){
            if(countMap.get(i) > a.length/2){
                result = i;
            }
        }

        return result;
    }
}
