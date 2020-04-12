package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最大深度
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/12 8:30 PM
 */
public class MaxDepth {
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

        int depth = maxDepth2(treeNode1);
        System.out.println(depth);
    }

    private static int maxDepth(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            depth++;
            int num = queue.size();
            for(int i = 0; i< num; i++){
                TreeNode node = queue.removeLast();
                if(node.left != null){
                    queue.offerLast(node.left);
                }
                if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
        }

        return depth;
    }

    private static int maxDepth2(TreeNode root){
        return root == null ? 0 : 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }
}
