package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 二叉搜索树的恢复
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/7 11:05 AM
 */
public class TreeRecover {
    TreeNode pre, first, second;

    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = null;
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = null;
        treeNode3.left = null;
        treeNode3.right = null;

        System.out.println(treeNode1);
        TreeRecover treeRecover = new TreeRecover();
        treeRecover.revocerTree(treeNode1);
        System.out.println(treeNode1);
    }

    private void revocerTree(TreeNode root){
        pre = null;
        first = null;
        second = null;
        inOrderSort(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    void inOrderSort(TreeNode root){
        if(root == null){
            return;
        }
        inOrderSort(root.left);
        if(pre == null){
            pre = root;
        }else{
            if(pre.val > root.val){
                if(first == null){
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }
        inOrderSort(root.right);
    }
}
