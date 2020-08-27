package com.github.algorithm.integer;

/**
 * 中位数计算
 *
 * @Author: zlzhang0122
 * @Date: 2019/12/4 7:25 PM
 */
public class MidNum {
    public static void main(String[] args){
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2};

        MidNum midNum = new MidNum();
        System.out.print(midNum.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArraysOne(int[] nums1, int[] nums2) {
        if(nums1 == null){
            nums1 = new int[0];
        }
        if(nums2 == null){
            nums2 = new int[0];
        }
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 < len2){
            return findMedianSortedArraysOne(nums2, nums1);
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

    public double findMedianSortedArraysNew(int[] nums1, int[] nums2) {
        if(nums1 == null){
            nums1 = new int[0];
        }
        if(nums2 == null){
            nums2 = new int[0];
        }
        int sumNum = nums1.length + nums2.length;
        int[] sum = new int[sumNum];
        int k = 0, i = 0, j = 0, n = nums1.length, m = nums2.length;
        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                sum[k] = nums1[i];
                i++;k++;
            }else{
                sum[k] = nums2[j];
                j++;k++;
            }
        }
        while(i < n){
            sum[k] = nums1[i];
            i++;k++;
        }
        while(j < m){
            sum[k] = nums2[j];
            j++;k++;
        }

        return (sum[(k - 1) / 2] + sum[k / 2]) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null){
            nums1 = new int[0];
        }
        if(nums2 == null){
            nums2 = new int[0];
        }
        int n = nums1.length, m = nums2.length;
        return (findMedianSortedNum(nums1, 0, nums2, 0, (n + m + 1) / 2)
                + findMedianSortedNum(nums1, 0, nums2, 0, (n + m + 2) / 2)) / 2.0;
    }

    private int findMedianSortedNum(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1 > nums1.length - 1){
            return nums2[start2 + k - 1];
        }
        if(start2 > nums2.length - 1){
            return nums1[start1 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }

        int numMid1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int numMid2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

        if(numMid1 < numMid2){
            return findMedianSortedNum(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }else{
            return findMedianSortedNum(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
