package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 二叉树的路径之和2
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/20 7:41 PM
 */
public class PathSum2 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = null;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.left = null;
        treeNode5.right = null;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode7.left = null;
        treeNode7.right = null;
        treeNode8.left = null;
        treeNode8.right = null;
        treeNode6.left = treeNode9;
        treeNode6.right = treeNode10;
        treeNode9.left = null;
        treeNode9.right = null;
        treeNode10.left = null;
        treeNode10.right = null;

        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();

        List<List<Integer>> res = pathSum(treeNode1, sum);
        for(List<Integer> item : res){
            for(Integer subItem : item){
                System.out.print(subItem + " ");
            }
            System.out.println("----------");
        }
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        pathSum(root, sum, out, res);
        return res;
    }

    private static void pathSum(TreeNode root, int sum, List<Integer> out, List<List<Integer>> res) {
        if(root == null){
            return;
        }
        out.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(out));
        }else{
            pathSum(root.left, sum - root.val, out, res);
            pathSum(root.right, sum - root.val, out, res);
        }
        out.remove(out.size() - 1);
    }
}
