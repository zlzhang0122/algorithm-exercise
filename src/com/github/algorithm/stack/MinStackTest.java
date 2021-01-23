package com.github.algorithm.stack;

import com.github.algorithm.util.StackDomain;

/**
 * 设计一个数据结构，使得该结构对于入栈、出栈和获取当前栈中最小值这三个方法的时间复杂度均为O(1)
 *
 * @Author: zlzhang0122
 * @Date: 2021/1/23 10:31 下午
 */
public class MinStackTest {
    public static void main(String[] args){
        int[] data = {6, 5, 9, 7, 3, 2, 1, 4, 4, 1};
        StackDomain stackDomain = new StackDomain();
        for(int i : data){
            stackDomain.push(i);
            System.out.println(stackDomain.toString());
        }
        System.out.println("-----------------------------");
        for(int i : data){
            stackDomain.pop();
            System.out.println(stackDomain.toString());
        }
    }
}
