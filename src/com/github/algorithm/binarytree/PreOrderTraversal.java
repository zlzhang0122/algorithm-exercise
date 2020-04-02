package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树先序遍历
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/2 9:46 PM
 */
public class PreOrderTraversal {
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

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();

        System.out.println("recursive:");
        List<Integer> list = preOrderTraversal.preOrderTraversalRecursive(treeNode1);
        for(Integer item : list){
            System.out.println(item);
        }

        System.out.println("iteratively:");
        List<Integer> otherList = preOrderTraversal.preOrderTraversalIteratively(treeNode1);
        for(Integer item : otherList){
            System.out.println(item);
        }
    }

    /**
     * 递归实现先序遍历
     *
     * @param root
     * @return
     */
    private List<Integer> preOrderTraversalRecursive(TreeNode root){
        List<Integer> list = new ArrayList<>();
        traversalRecursive(list, root);
        return list;
    }

    /**
     * 递归实现先序遍历
     *
     * @param root
     * @param root
     */
    private void traversalRecursive(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }

        list.add(root.val);
        traversalRecursive(list, root.left);
        traversalRecursive(list, root.right);
    }

    /**
     * 循环实现先序遍历
     *
     * @param root
     * @return
     */
    private List<Integer> preOrderTraversalIteratively(TreeNode root){
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return list;
    }
}
