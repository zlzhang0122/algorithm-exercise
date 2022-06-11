package com.github.algorithm.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List遍历问题
 *
 * @Author: zlzhang0122
 * @Date: 2022/6/11 下午2:15
 */
public class ListTraverse {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args){
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        List<Integer> track = new ArrayList<>();
        backTraverse(nums, track);
        for (List<Integer> list : res) {
            for (int item : list) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }

    public static void backTraverse(int[] nums, List<Integer> track){
        if(nums.length == track.size()) {
            List<Integer> item = new ArrayList<>(track);
            res.add(item);
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backTraverse(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
