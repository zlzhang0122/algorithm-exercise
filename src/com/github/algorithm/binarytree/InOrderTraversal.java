package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/2 8:42 PM
 */
public class InOrderTraversal {

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

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        List<Integer> list = inOrderTraversal.inorderTraversal(treeNode1);
        for(Integer item : list){
            System.out.println(item);
        }
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(list, root);
        return list;
    }

    /**
     * 递归
     *
     * @param list
     * @param root
     */
    public void traversal(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }else{
            traversal(list, root.left);
            list.add(root.val);
            traversal(list, root.right);
        }
    }
}
