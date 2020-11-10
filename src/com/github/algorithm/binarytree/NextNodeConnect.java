package com.github.algorithm.binarytree;

import com.github.algorithm.util.ListTreeNode;

/**
 * 完美二叉树Next节点连接
 *
 * @Author: zlzhang0122
 * @Date: 2020/11/10 11:47 上午
 */
public class NextNodeConnect {
    public static void main(String[] args) {
        ListTreeNode node1 = new ListTreeNode(1);
        ListTreeNode node2 = new ListTreeNode(2);
        ListTreeNode node3 = new ListTreeNode(3);
        ListTreeNode node4 = new ListTreeNode(4);
        ListTreeNode node5 = new ListTreeNode(5);
        ListTreeNode node6 = new ListTreeNode(6);
        ListTreeNode node7 = new ListTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;
        node7.left = null;
        node7.right = null;

        System.out.println(node1.toString());
        ListTreeNode nodeNew = connect(node1);
        System.out.println(nodeNew.toString());
    }

    public static ListTreeNode connect(ListTreeNode root) {
        fillNext(root);
        return root;
    }

    public static ListTreeNode connect1(ListTreeNode root) {
        if(root == null){
            return null;
        }
        while(root != null){
            ListTreeNode temp = root;
            ListTreeNode left = temp.left;

        }

        return root;
    }

    private static void fillNext(ListTreeNode root) {
        if(root == null) {
            return;
        }
        ListTreeNode left = root.left;
        ListTreeNode right = root.right;
        if(left != null) {

        }
    }
}
