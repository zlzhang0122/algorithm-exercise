package com.github.algorithm.ValidParentheses;

import java.util.Stack;

/**
 * 括号匹配问题
 *
 * @Author: zlzhang0122
 * @Date: 2020/3/1 10:03 AM
 */
public class ValidParentheses {
    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid1 = validParentheses.isValid("([{}])");
        System.out.println(valid1);

        boolean valid2 = validParentheses.isValid("}");
        System.out.println(valid2);

        boolean valid3 = validParentheses.isValid("}");
        System.out.println(valid3);
    }

    private boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        if(str == null || str.length() == 0){
            return true;
        }else{
            for(char c : str.toCharArray()){
                if(c == '(' || c == '[' || c == '{'){
                    stack.push(c);
                }else if(c == ')'){
                    if(stack.empty()){
                        return false;
                    }else{
                        char item = stack.peek();
                        if(item == '('){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }
                }else if(c == ']'){
                    if(stack.empty()){
                        return false;
                    }else{
                        char item = stack.peek();
                        if(item == '['){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }
                }else if(c == '}'){
                    if(stack.empty()){
                        return false;
                    }else{
                        char item = stack.peek();
                        if(item == '{'){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
