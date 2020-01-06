package com.github.algorithm.stocktrade;

/**
 * @Author: zlzhang0122
 * @Date: 2020/1/6 5:53 PM
 */
public class StockOne {
    public static void main(String[] args){
        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr = {7, 6, 5, 4, 3, 2, 1};
//        int[] arr = {1, 2, 3, 4, 5};

        int res1 = maxTradeProfitOne(arr);
        System.out.println(res1);

        int res2 = maxTradeProfitTwo(arr);
        System.out.println(res2);
    }

    /**
     * 只允许购买一次和卖出一次
     *
     * @param arr
     * @return
     */
    private static int maxTradeProfitOne(int[] arr){
        int min = Integer.MAX_VALUE, profit = 0;
        if(arr == null){
            return 0;
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }

            profit = Math.max(arr[i] - min, profit);
        }

        return profit;
    }

    private static int maxTradeProfitTwo(int[] arr){
        int min = Integer.MAX_VALUE, profit = 0;
        if(arr == null){
            return 0;
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }else{
                profit = profit + arr[i] - min;
                min = arr[i];
            }
        }

        return profit;
    }
}
