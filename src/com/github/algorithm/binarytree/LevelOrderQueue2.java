package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.*;

/**
 * 二叉树层序遍历二
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/12 11:31 AM
 */
public class LevelOrderQueue2 {
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

        List<List<Integer>> res = levelOrder2(treeNode1);
        System.out.println(res);
    }

    private static List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> itemList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                itemList.add(node.val);
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
            res.add(itemList);
        }
        Collections.reverse(res);
        return res;
    }

    private static List<List<Integer>> levelOrder21(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int maxHeight = height(root);
        for(int i = 0; i< maxHeight; i++){
            res.add(new ArrayList<>());
        }
        findAns(res, root, 0);
        Collections.reverse(res);

        return res;
    }

    private static void findAns(List<List<Integer>> ans, TreeNode node, int num){
        if(node == null){
            return;
        }
        ans.get(num).add(node.val);
        findAns(ans, node.left, num + 1);
        findAns(ans, node.right, num + 1);
    }

    private static int height(TreeNode root){
        return root == null ? 0 : Math.max(height(root.left),height(root.right)) + 1;
    }
}
