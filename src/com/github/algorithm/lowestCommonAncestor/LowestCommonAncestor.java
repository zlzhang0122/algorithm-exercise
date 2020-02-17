package com.github.algorithm.lowestCommonAncestor;

import com.github.algorithm.util.TreeNode;

import java.util.Scanner;

/**
 * 最近公共祖先
 *
 * @Author: zlzhang0122
 * @Date: 2020/2/17 11:33 PM
 */
public class LowestCommonAncestor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int rootData = scanner.nextInt();

        TreeNode root = new TreeNode(rootData);
        boolean flag = false;
        for(int i = 0; i < line; i++){
            int itemRoot = scanner.nextInt();
            int itemLeft = scanner.nextInt();
            int itemRight = scanner.nextInt();


        }
    }


}
