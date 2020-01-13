package com.github.algorithm.mostwater;

/**
 * 盛最多的水
 *
 * @Author: zlzhang0122
 * @Date: 2020/1/13 8:21 PM
 */
public class MostWater {
    public static void main(String[] args){
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int mostWater = maxArea(arr);
        System.out.println(mostWater);
    }

    public static int maxArea(int[] height){
        int max = 0, i = 0, j = height.length - 1;
        while(i < j){
            if(height[i] < height[j]){
                max = height[i] * (j - i) > max ? height[i] * (j - i) : max;
                i++;
            }else{
                max = height[j] * (j - i) > max ? height[j] * (j - i) : max;
                j--;
            }
        }

        return max;
    }
}
