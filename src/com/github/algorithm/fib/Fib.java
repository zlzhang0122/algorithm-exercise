package com.github.algorithm.fib;

/**
 * @Author: zlzhang0122
 * @Date: 2022/6/8 下午6:09
 */
public class Fib {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        long res1 = fib1(20);
        System.out.println(res1 + ", " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        long res2 = fib2(20);
        System.out.println(res2 + ", " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        long res3 = fib3(20);
        System.out.println(res3 + ", " + (System.currentTimeMillis() - start3));

        long start4 = System.currentTimeMillis();
        long res4 = fib4(20);
        System.out.println(res4 + ", " + (System.currentTimeMillis() - start4));
    }

    public static long fib1(int n){
        if(n == 0) {
            return 0;
        }
        if(n== 1 || n== 2){
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static long fib2(int n){
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        long[] helper = new long[n + 1];
        return help(helper, n);
    }

    private static long help(long[] helper, int n){
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if(helper[n] != 0) return helper[n];
        helper[n] = help(helper, n - 1) + help(helper, n - 2);
        return helper[n];
    }

    public static long fib3(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        for(int i = 3; i <= n; i++){
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static long fib4(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int prev = 1, cur = 1;
        for(int i = 3; i <= n; i++){
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }
}
