package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 根据二叉树中序和后序结果构造二叉树
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/12 8:53 PM
 */
public class InAndPostBuildTree {
    public static void main(String[] args){
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int lstart, int lend, int[] postorder, int rstart, int rend){
        if(lstart > lend || rstart > rend){
            return null;
        }
        int i = 0;
        for(; i <= lend; i++){
            if(postorder[rend] == inorder[lstart + i]){
                break;
            }
        }
        TreeNode treeNode = new TreeNode(postorder[rend]);
        treeNode.left = build(inorder, lstart,  lstart + i - 1, postorder, rstart, rstart + i - 1);
        treeNode.right = build(inorder, lstart + i + 1, lend, postorder, rstart + i, rend - 1);
        return treeNode;
    }
}
