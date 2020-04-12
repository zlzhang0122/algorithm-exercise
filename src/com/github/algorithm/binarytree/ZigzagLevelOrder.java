package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序之字型遍历
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/12 8:18 PM
 */
public class ZigzagLevelOrder {
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

        List<List<Integer>> res = zigzagLevelOrder(treeNode1);
        System.out.println(res);
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int k = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> itemList = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                if(k % 2 == 0){
                    itemList.addLast(node.val);
                }else{
                    itemList.addFirst(node.val);
                }
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
            res.add(itemList);
        }
        return res;
    }
}
