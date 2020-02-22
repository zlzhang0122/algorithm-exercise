package com.github.algorithm.lowestCommonAncestor;

import com.github.algorithm.util.TreeNode;

import java.util.Scanner;

/**
 * 最近公共祖先
 *
 * @Author: zlzhang0122
 * @Date: 2020/2/17 11:33 PM
 */
public class LowestCommonAncestor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int rootData = scanner.nextInt();

        TreeNode root = new TreeNode(rootData);
        for(int i = 0; i < line; i++){
            int itemRoot = scanner.nextInt();
            int itemLeft = scanner.nextInt();
            int itemRight = scanner.nextInt();

            TreeNode node = findByValue(root, itemRoot);
            if(itemLeft != 0){
                TreeNode left = new TreeNode(itemLeft);
                node.left = left;
            }
            if(itemRight != 0){
                TreeNode right = new TreeNode(itemRight);
                node.right = right;
            }
        }
        System.out.println(root);


        System.out.println("please input two node value to find their ancestor:");
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        TreeNode leftNode = findByValue(root, left);
        TreeNode rightNode = findByValue(root, right);

        TreeNode ancestor = lowestCommonAncestor(root, leftNode, rightNode);
        System.out.println(ancestor.data);
    }

    /**
     * 根据节点值查找
     *
     * @param root
     * @param value
     * @return
     */
    private static  TreeNode findByValue(TreeNode root, int value){
        if(root == null){
            return null;
        }
        if(root.data == value){
            return root;
        }
        TreeNode left = findByValue(root.left, value);
        if(left != null){
            return left;
        }else{
            TreeNode right = findByValue(root.right, value);
            if(right == null){
                return null;
            }else {
                return right;
            }
        }
    }


    /**
     * 查找最近公共父节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }

        return root;
    }
}
