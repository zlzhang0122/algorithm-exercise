package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/4 5:07 PM
 */
public class PostOrderTraversal {
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

        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();

        System.out.println("recursive:");
        List<Integer> list = postOrderTraversal.postOrderTraversalRecursive(treeNode1);
        for(Integer item : list){
            System.out.println(item);
        }

        System.out.println("iteratively1:");
        List<Integer> otherList1 = postOrderTraversal.postOrderTraversalIteratively1(treeNode1);
        for(Integer item : otherList1){
            System.out.println(item);
        }

        System.out.println("iteratively2:");
        List<Integer> otherList2 = postOrderTraversal.postOrderTraversalIteratively2(treeNode1);
        for(Integer item : otherList2){
            System.out.println(item);
        }
    }

    /**
     * 递归实现后序遍历
     *
     * @param root
     * @return
     */
    private List<Integer> postOrderTraversalRecursive(TreeNode root){
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
    private void traversal(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }
        traversal(list, root.left);
        traversal(list, root.right);
        list.add(root.val);
    }


    /**
     * 循环实现后序遍历，用额外空间
     *
     * @param root
     * @return
     */
    private List<Integer> postOrderTraversalIteratively1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> stackRes = new Stack<>();
        Stack<TreeNode> stackTemp = new Stack<>();
        stackTemp.push(root);
        while(!stackTemp.isEmpty()){
            TreeNode node = stackTemp.pop();
            stackRes.push(node);
            if(node.left != null){
                stackTemp.push(node.left);
            }
            if(node.right != null){
                stackTemp.push(node.right);
            }
        }

        while(!stackRes.isEmpty()){
            list.add(stackRes.pop().val);
        }
        return list;
    }

    /**
     * 循环实现后序遍历
     *
     * @param root
     * @return
     */
    private List<Integer> postOrderTraversalIteratively2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode h = root;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur.left != null && h != cur.left && h != cur.right){
                stack.push(cur.left);
            }else if(cur.right != null && h != cur.right){
                stack.push(cur.right);
            }else{
                list.add(stack.pop().val);
                h = cur;
            }
        }


        return list;
    }
}
