package com.github.algorithm.heap;

import java.util.Arrays;

/**
 * 大顶堆(即根节点大于左右子树的堆)
 *
 * @Author: zlzhang0122
 * @Date: 2020/8/27 4:45 下午
 */
public class MaxHeap {
    public static int left(int i){
        return (i + 1) * 2 -1;
    }

    public static int right(int i){
        return (i + 1) * 2;
    }

    public static int parent(int i){
        return (i - 1) / 2;
    }

    public static void heapKeep(int[] arr, int i, int k){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < k && arr[i] < arr[l]){
            largest = l;
        }
        if(r < k && arr[largest] < arr[r]){
            largest = r;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapKeep(arr, largest, k);
        }
    }

    public static int buildHeap(int[] arr, int k){
        if(arr == null || arr.length < k){
            return -1;
        }else{
            int parent = parent(k - 1);
            for(int i = parent; i >= 0; i--){
                heapKeep(arr, i, k);
            }
            return 0;
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 5, 2, 3, 8, 4};
        buildHeap(arr, 6);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
