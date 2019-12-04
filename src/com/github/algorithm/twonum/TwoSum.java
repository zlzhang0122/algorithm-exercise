package com.github.algorithm.twonum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和的计算
 *
 * @Author: zlzhang0122
 * @Date: 2019/12/1 9:26 PM
 */
public class TwoSum {
    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = twoSum.twoSum(nums, 9);

        System.out.print(res[0] + "," + res[1]);
    }

    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int except = target - nums[i];
            if(map.containsKey(except)){
                res[0] = map.get(except);
                res[1] = i;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
