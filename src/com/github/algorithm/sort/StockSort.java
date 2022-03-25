package com.github.algorithm.sort;

/**
 * 桶排序
 *
 * @Author: zlzhang0122
 * @Date: 2022/3/1 下午8:28
 */
public class StockSort {
    public static void main(String[] args){
        int[] res = new int[11];
        int[] a = {5, 3, 5, 2, 8};
        for(int i : a){
            res[i]++;
        }
        for(int i = 0; i < res.length; i++){
            while(res[i]-- > 0){
                System.out.println(i);
            }
        }
    }
}
