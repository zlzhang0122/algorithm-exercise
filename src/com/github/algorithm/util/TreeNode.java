package com.github.algorithm.util;

/**
 * 二叉树
 *
 * @Author: zlzhang0122
 * @Date: 2020/2/17 11:35 PM
 */
public class TreeNode {
    public int val;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    public String toString(){
        return val + ":" + ((left != null) ? left.toString() : "null") + "," + ((right != null) ? right.toString() : "null");
    }
}
