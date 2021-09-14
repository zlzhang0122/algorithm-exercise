package com.github.algorithm.sort;

/**
 * @Author: zlzhang0122
 * @Date: 2021/9/14 11:56 下午
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] a = {5, 3, 5, 2, 8};
        for(int i = 0; i < a.length; i++)
            for(int j = i + 1; j < a.length; j++){
                if(a[i] < a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        for(int i : a){
            System.out.println(i);
        }
    }
}
