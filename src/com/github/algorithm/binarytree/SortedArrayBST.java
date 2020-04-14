package com.github.algorithm.binarytree;

import com.github.algorithm.util.TreeNode;

/**
 * 有序数组构建二叉搜索树
 *
 * @Author: zlzhang0122
 * @Date: 2020/4/14 7:50 PM
 */
public class SortedArrayBST {
    public static void main(String[] args){
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = initBST(nums, 0, nums.length);
        return root;
    }

    private static TreeNode initBST(int[] nums, int start, int end){
        if(start >= end){
            return null;
        }
        int index = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = initBST(nums, start, index);
        root.right = initBST(nums, index + 1, end);

        return root;
    }
}
