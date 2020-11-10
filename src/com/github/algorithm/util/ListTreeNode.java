package com.github.algorithm.util;

/**
 * @Author: zlzhang0122
 * @Date: 2020/11/10 11:52 上午
 */
public class ListTreeNode {
    public int val;

    public ListTreeNode left;
    public ListTreeNode right;
    public ListTreeNode next;

    public ListTreeNode(int val){
        this.val = val;
    }

    public String toString(){
        return val + ":" + ((left != null) ? left.toString() : "null") + "," + ((right != null) ? right.toString() : "null")
                + "," + ((next != null) ? next.toString() : "null");
    }
}
