package com.github.algorithm.binarytree;

import java.util.Scanner;

/**
 * 二叉搜索树可能的个数
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/5 11:07 PM
 */
public class BSTCount {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = numTrees(n);
        System.out.println(res);
    }

    public static int numTrees(int n){
        if(n <= 0){
            return 1;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                res[i] += res[j - 1] * res[i - j];
            }
        }
        return res[n];
    }
}
