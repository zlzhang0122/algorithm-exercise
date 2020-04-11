package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 二叉树校验，验证是否是同一棵树
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/11 8:57 PM
 */
public class SameTree {
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

        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode31 = new TreeNode(4);
        treeNode11.left = null;
        treeNode11.right = treeNode21;
        treeNode21.left = treeNode31;
        treeNode21.right = null;
        treeNode31.left = null;
        treeNode31.right = null;

        boolean flag = judge(treeNode1, treeNode1);
        System.out.println(flag);

        boolean flag2 = judge(treeNode1, treeNode11);
        System.out.println(flag2);
    }

    private static boolean judge(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null){
            return false;
        }else{
            if(root1.val != root2.val){
                return false;
            }else{
                return judge(root1.left, root2.left) && judge(root1.right, root2.right);
            }
        }
    }
}
