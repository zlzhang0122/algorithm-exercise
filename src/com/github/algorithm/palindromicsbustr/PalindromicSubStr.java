package com.github.algorithm.palindromicsbustr;

/**
 * 最长回文子字符串
 *
 * @Author: zlzhang0122
 * @Date: 2019/12/7 9:33 PM
 */
public class PalindromicSubStr {
    public static void main(String[] args){
        PalindromicSubStr palindromicSubStr = new PalindromicSubStr();
        String s = palindromicSubStr.longestPalindrome("babad");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 0){
            return "";
        }
        int start = 0, end = 0, maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = longestSubStr(s, i, i);
            int len2 = longestSubStr(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > maxLength){
                maxLength = len;
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    private int longestSubStr(String s, int start, int end){
        while(start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
