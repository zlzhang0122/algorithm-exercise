package com.github.algorithm.exercise;

import java.util.Arrays;

/**
 * 找零钱
 *
 * @Author: zlzhang0122
 * @Date: 2022/6/11 下午1:42
 */
public class Coins {
    public static void main(String[] args){
        int[] coins = new int[3];
        coins[0] = 1;
        coins[1] = 2;
        coins[2] = 5;
        int res = findCoin(coins, 11);
        System.out.println(res);
    }

    public static int findCoin(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, amount + 1);
        res[0] = 0;
        for(int i = 0; i < res.length; i++){
            for(int temp : coins) {
                if (i - temp < 0) continue;
                res[i] = Math.min(res[i], 1 + res[i - temp]);
            }
        }
        return res[amount] == amount + 1 ? -1 : res[amount];
    }
}
