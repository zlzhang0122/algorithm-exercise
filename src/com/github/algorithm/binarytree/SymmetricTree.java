package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 判断对称树
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/11 9:56 PM
 */
public class SymmetricTree {
    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = null;
        treeNode3.left = treeNode5;
        treeNode3.right = null;

        boolean flag = judge(treeNode1);
        System.out.println(flag);
    }

    private static boolean judge(TreeNode root){
        if(root == null){
            return true;
        }

        return judgeSymmetric(root.left, root.right);
    }

    private static boolean judgeSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null || left.val != right.val){
            return false;
        }else{
            return judgeSymmetric(left.left, right.right) && judgeSymmetric(left.right, right.left);
        }
    }
}
