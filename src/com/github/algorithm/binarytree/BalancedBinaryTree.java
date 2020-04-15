package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 树高度平衡的二叉树
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/15 7:59 PM
 */
public class BalancedBinaryTree {

    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = null;
        treeNode1.right = treeNode2;
        treeNode2.left = null;
        treeNode2.right = treeNode3;
        treeNode3.left = null;
        treeNode3.right = null;

        boolean res = isBalanced2(treeNode1);
        System.out.println(res);
    }

    private static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int depth = Math.abs(getDepth(root.left) - getDepth(root.right));
        if(depth > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getDepth(TreeNode root){
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    private static boolean isBalanced2(TreeNode root) {
        if(checkBalanced(root) == -1){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 如果左右子树中有一个不符合，那么该树不符合
     *
     * @param root
     * @return
     */
    private static int checkBalanced(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = checkBalanced(root.left);
        if(left == -1){
            return -1;
        }
        int right = checkBalanced(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }else{
            return 1 + Math.max(left, right);
        }
    }
}
