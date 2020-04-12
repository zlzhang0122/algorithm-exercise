package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 根据二叉树先序和中序结果构造二叉树
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/12 8:53 PM
 */
public class PreAndInBuildTree {
    public static void main(String[] args){
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int start, int end, int[] inorder, int startSecond, int endSecond){
        if(start > end || startSecond > endSecond){
            return null;
        }
        int i = 0;
        for(i = startSecond; i <= endSecond; i++){
            if(preorder[start] == inorder[i]){
                break;
            }
        }
        TreeNode treeNode = new TreeNode(preorder[start]);
        treeNode.left = build(preorder, start + 1, start + i - startSecond, inorder, startSecond, i - 1);
        treeNode.right = build(preorder, start + i - startSecond + 1, end, inorder, i + 1, endSecond);
        return treeNode;
    }
}
