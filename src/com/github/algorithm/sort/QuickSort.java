package com.github.algorithm.sort;

/**
 * 快速排序
 *
 * @Author: zlzhang0122
 * @Date: 2020/1/9 3:15 PM
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {1, 7, 9, 3, 2, 5, 4, 7};
        print(arr);

        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int index = quick(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int quick(int[] arr, int low, int high){
        int temp = arr[low];
        while(low < high){
            while(low < high && arr[high] >= temp){
                high--;
            }
            arr[low] = arr[high];

            while(low < high && arr[low] <= temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    private static void print(int[] arr){
        for(int item : arr){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
