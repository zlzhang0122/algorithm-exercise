package com.github.algorithm.util;

import java.util.Stack;

/**
 * 设计一个数据结构，使得该结构对于入栈、出栈和获取当前栈中最小值这三个方法的时间复杂度均为O(1)
 *
 * @Author: zlzhang0122
 * @Date: 2021/1/23 10:54 下午
 */
public class StackDomain {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public StackDomain(){
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public StackDomain(Stack<Integer> dataStack, Stack<Integer> minStack){
        this.dataStack = dataStack;
        this.minStack = minStack;
    }

    public void push(int data){
        dataStack.push(data);
        if(minStack.size() > 0){
            if(minStack.peek() >= data){
                minStack.push(data);
            }
        }else{
            minStack.push(data);
        }
    }

    public Integer pop(){
        int value = -1;
        if(minStack.size() > 0 && dataStack.size() > 0){
            value = dataStack.pop();
            if(value == minStack.peek()){
                minStack.pop();
            }
        }
        return value;
    }

    public int min(){
        if(minStack.size() > 0){
            return minStack.peek();
        }
        return -1;
    }

    public String toString(){
        return dataStack.toString() + ":" + minStack.toString();
    }
}
