package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 二叉树的路径之和
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/20 7:41 PM
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = null;
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = null;
        treeNode3.left = null;
        treeNode3.right = null;

        boolean flag = hasPathSum(treeNode1, 6);
        System.out.println(flag);

        boolean flag1 = hasPathSum(treeNode1, 5);
        System.out.println(flag1);
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
