package com.github.algorithm.midnum;

/**
 * @Author: zlzhang0122
 * @Date: 2019/12/4 7:25 PM
 */
public class MidNum {
    public static void main(String[] args){
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};

        MidNum midNum = new MidNum();
        System.out.print(midNum.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null){
            nums1 = new int[0];
        }
        if(nums2 == null){
            nums2 = new int[0];
        }
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 < len2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1, l2, r1, r2, mid1, mid2, lo = 0, hi = 2 * len2;
        while(lo <= hi){
            mid2 = (lo + hi) / 2;
            mid1 = len1 + len2 - mid2;

            l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];

            r1 = (mid1 == 2 * len1) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            r2 = (mid2 == 2 * len2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if(l1 > r2){
                lo = mid2 + 1;
            }else if(l2 > r1){
                hi = mid1 - 1;
            }else{
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
        }

        return -1;
    }
}
