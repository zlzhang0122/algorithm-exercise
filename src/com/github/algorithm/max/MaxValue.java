package com.github.algorithm.max;

import com.github.algorithm.util.MathUtils;

import java.time.LocalDateTime;

/**
 * @Author: zlzhang0122
 * @Date: 2021/11/9 上午10:21
 */
public class MaxValue {
    public static void main(String[] args){
        int[] arr = {1, 2, 5, 7, 8, 8, 8, 9, 6, 3, -1};
        int max = max(arr);
        System.out.println(max);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Integer s0 = 0;
        int key0 = MathUtils.murmurHash(s0.hashCode()) % 128;
        int res0 = key0 * 4 / 128;

        System.out.println(res0);

        Integer s1 = 23;
        int key1 = MathUtils.murmurHash(s1.hashCode()) % 128;
        int res1 = key1 * 4 / 128;

        System.out.println(res1);

        Integer s2 = 66;
        int key2 = MathUtils.murmurHash(s2.hashCode()) % 128;
        int res2 = key2 * 4 / 128;
        System.out.println(res2);

        Integer s3 = 99;
        int key3 = MathUtils.murmurHash(s3.hashCode()) % 128;
        int res3 = key3 * 4 / 128;
        System.out.println(res3);
    }

    public static int max(int[] arr){
        return -1;
    }
}
