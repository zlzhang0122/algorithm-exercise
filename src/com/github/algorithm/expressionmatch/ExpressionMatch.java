package com.github.algorithm.expressionmatch;

/**
 * @Author: zlzhang0122
 * @Date: 2020/1/13 8:32 PM
 */
public class ExpressionMatch {
    public static void main(String[] args){
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean flag = isMatch(s, p);
        System.out.println("s:" + s + ", p:" + p + " : " + flag);
    }

    public static boolean isMatch(String s, String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean firstFlag = (!s.isEmpty()) && (s.charAt(0) == p.charAt(0) || (p.charAt(0) == '.'));
        if(p.length() >=2 && p.charAt(1) == '*'){
            return (firstFlag && isMatch(s.substring(1), p)) || (isMatch(s, p.substring(2)));
        }else{
            return firstFlag && isMatch(s.substring(1), p.substring(1));
        }
    }
}
