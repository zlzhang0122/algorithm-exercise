package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 二叉搜索树的所有可能性子树
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/5 11:07 PM
 */
public class BSTDetail {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<TreeNode> res = generateTrees(n);
        for(TreeNode treeNode : res){
            System.out.println(treeNode.toString());
        }
    }

    private static List<TreeNode> generateTrees(int n){
        if(n < 1){
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    private static List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTree = generate(start, i -1);
            List<TreeNode> rightTree = generate(i + 1, end);
            for(TreeNode leftTreeItem : leftTree){
                for(TreeNode rightTreeItem : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTreeItem;
                    root.right = rightTreeItem;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
