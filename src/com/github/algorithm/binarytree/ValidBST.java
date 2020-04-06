package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 二叉搜索树的验证
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/6 8:03 PM
 */
public class ValidBST {
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

        System.out.println(isValidTree(treeNode1));
    }

    private static boolean isValidTree(TreeNode treeNode){
        if(treeNode == null){
            return true;
        }
        return isValid(treeNode, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long low, long high){
        if(root == null){
            return true;
        }
        if(root.val <= low || root.val >= high){
            return false;
        }

        return isValid(root.left, low, root.val)
                && isValid(root.right, root.val, high);
    }
}
