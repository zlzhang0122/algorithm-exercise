package com.github.algorithm.stocktrade;

/**
 * 只允许购买一次和卖出一次
 *
 * @Author: zlzhang0122
 * @Date: 2020/1/6 5:53 PM
 */
public class StockOne {
    public static void main(String[] args){
//        int[] arr = {7, 1, 5, 3, 6, 4};
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        int res = maxTradeSum(arr);

        System.out.println(res);
    }

    private static int maxTradeSum(int[] arr){
        int min = Integer.MAX_VALUE, profile = 0;
        if(arr == null){
            return 0;
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }

            profile = Math.max(arr[i] - min, profile);
        }

        return profile;
    }
}
