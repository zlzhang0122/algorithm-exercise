package com.github.algorithm.integer;

/**
 * 整数反序
 *
 * @Author: zlzhang0122
 * @Date: 2019/12/7 10:09 PM
 */
public class ReverseInteger {
    public static void main(String[] args){
        ReverseInteger reverseInteger = new ReverseInteger();
        int res = reverseInteger.reverse(-100);
        System.out.println(res);
    }

    public int reverse(int x){
        int res = 0;
        while(x != 0){
            int temp = x % 10;
            x = x / 10;

            if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && temp > 7){
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && temp < -8){
                return 0;
            }

            res = 10 * res + temp;
        }

        return res;
    }
}
