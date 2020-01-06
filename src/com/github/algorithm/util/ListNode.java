package com.github.algorithm.util;

/**
 * @Author: zlzhang0122
 * @Date: 2019/12/1 9:45 PM
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public String toString(){
        return "val:" + val + "->" + (next != null ? next.toString() : "null");
    }
}