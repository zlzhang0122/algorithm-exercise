package com.github.algorithm.util;

/**
 * 二叉树
 *
 * @Author: zlzhang0122
 * @Date: 2020/2/17 11:35 PM
 */
public class TreeNode {
    public int data;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }

    public String toString(){
        return data + ":" + ((left != null) ? left.toString() : "null") + "," + ((right != null) ? right.toString() : "null");
    }
}
