package com.github.algorithm.other;

import java.util.Scanner;

/**
 * 斐波那契的计算
 *
 * @Author: zlzhang0122
 * @Date: 2020/8/31 11:27 下午
 */
public class Feibonaqi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(getFeibonaqi(number));

        int number2 = scanner.nextInt();
        System.out.println(getFeibonaqiWithoutRecursion(number2));
    }

    public static int getFeibonaqi(int n){
        if(n < 3){
            return 1;
        }
        return getFeibonaqi(n - 1) + getFeibonaqi(n - 2);
    }

    public static int getFeibonaqiWithoutRecursion(int n){
        if(n < 3){
            return 1;
        }
        int first = 1, second = 1;
        int i = 3;
        while(i <= n){
            int temp = first;
            first = second;
            second = temp + second;
            i++;
        }
        return second;
    }
}
