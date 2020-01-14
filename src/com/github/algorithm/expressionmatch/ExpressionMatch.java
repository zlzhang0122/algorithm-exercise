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

    public static boolean isMatch2(String s, String p){
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for(int i = s.length(); i >= 0; i--){
            for(int j = p.length(); j >=0; j--){
                if(i == s.length() && j == p.length()){
                    continue;
                }

                boolean firstFlag = (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j)
                        || p.charAt(j) == '.'));

                if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                    return dp[i][j + 2] || firstFlag && dp[i + 1][j];
                }else{
                    return firstFlag && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
