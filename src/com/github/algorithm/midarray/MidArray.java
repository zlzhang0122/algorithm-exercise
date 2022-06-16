package com.github.algorithm.midarray;

/**
 * @Author: zlzhang0122
 * @Date: 2022/6/15 下午6:38
 */
public class MidArray {
    public static void main(String[] args){
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {3, 4, 6, 8};
        int len1 = arr1.length, len2 = arr2.length;
        int k1 = (len1 + len2 + 1) / 2, k2 = (len1 + len2 + 2) / 2;
        int res = (findMidArray(arr1, 0, arr2, 0, k1) + findMidArray(arr1, 0, arr2, 0, k2)) / 2;
        System.out.println(res);
    }

    private static int findMidArray(int[] arr1, int start1, int[] arr2, int start2, int k) {
        if(start1 > arr1.length){
            return arr2[start2 + k - 1];
        }
        if(start2 > arr2.length){
            return arr1[start1 + k - 1];
        }
        if(k == 1){
            return Math.min(arr1[start1], arr2[start2]);
        }
        int mid1 = (start1 + k / 2 - 1 > arr1.length) ? Integer.MAX_VALUE : arr1[start1 + k / 2 - 1];
        int mid2 = (start2 + k / 2 - 1 > arr2.length) ? Integer.MAX_VALUE : arr2[start2 + k / 2 - 1];
        if (mid1 < mid2){
            return findMidArray(arr1, start1 + k /2, arr2, start2, k - k / 2);
        } else {
            return findMidArray(arr1, start1, arr2, start2 + k / 2, k - k / 2);
        }
    }
}
