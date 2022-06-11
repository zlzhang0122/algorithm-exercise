package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最短高度
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/19 11:06 PM
 */
public class MinDepth {
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

        int res = minDepth(treeNode1);
        System.out.println(res);

        int res1 = minDepth2(treeNode1);
        System.out.println(res1);
    }

    private static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        if(root.right == null){
            return 1 + minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    private static int minDepth2(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode item = queue.poll();
                if (item.left == null && item.right == null){
                    return depth;
                }
                if(item.left != null){
                    queue.offer(item.left);
                }
                if(item.right != null){
                    queue.offer(item.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
