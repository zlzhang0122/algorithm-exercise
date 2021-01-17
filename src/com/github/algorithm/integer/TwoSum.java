package com.github.algorithm.integer;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和的计算(有重复数据情况和无重复数据情况)
 *
 * @Author: zlzhang0122
 * @Date: 2019/12/1 9:26 PM
 */
public class TwoSum {
    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15, 3, 6, 6, 3};
        int[] res = twoSum.twoSum(nums, 9);

        System.out.println("find: " + res[0] + "," + res[1]);
        //有重复数据时的情况
        twoSum.twoSum2(nums, 9);
    }

    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int except = target - nums[i];
            if(map.containsKey(except)){
                res[0] = map.get(except);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public void twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int except = target - nums[i];
            if(map.containsValue(except)){
                for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                    if(entry.getValue() == except){
                        System.out.println("find: index:" + i + ",value:" + nums[i] +
                                ", index:" + entry.getKey() + ",value:" + entry.getValue());
                    }
                }
            }
            map.put(i, nums[i]);
        }
    }
}
