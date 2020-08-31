package com.github.algorithm.other;

import java.util.Arrays;

/**
 * 小顶堆(即根节点小于左右子树的堆)
 *
 * @Author: zlzhang0122
 * @Date: 2020/8/27 4:45 下午
 */
public class MinHeap {
    public static int left(int i){
        return (i + 1) * 2 -1;
    }

    public static int right(int i){
        return (i + 1) * 2;
    }

    public static int parent(int i){
        return (i - 1) / 2;
    }

    public static void setRoot(int[] arr, int root, int k){
        arr[0] = root;
        heapKeep(arr, 0, k);
    }

    public static void heapKeep(int[] arr, int i, int k){
        int l = left(i);
        int r = right(i);
        int minimal = i;
        if(l < k && arr[i] > arr[l]){
            minimal = l;
        }
        if(r < k && arr[minimal] > arr[r]){
            minimal = r;
        }
        if(minimal != i){
            int temp = arr[minimal];
            arr[minimal] = arr[i];
            arr[i] = temp;
            heapKeep(arr, minimal, k);
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
        int[] arr = {1, 5, 2, 3, 6, 4};
        int[] data = new int[4];
        for(int i = 0; i < 4; i++){
            data[i] = arr[i];
        }
        buildHeap(data, 4);
        Arrays.stream(data).forEach(System.out::println);
        for(int i = 4; i < arr.length; i++){
            if(arr[i] > data[0]){
                setRoot(data, arr[i], 4);
            }
        }
        Arrays.stream(data).forEach(System.out::println);
    }
}
