package com.github.algorithm.longestsubstr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zlzhang0122
 * @Date: 2019/12/3 8:02 PM
 */
public class LongestSubStr {
    public static void main(String[] args){
        LongestSubStr longestSubStr = new LongestSubStr();
        System.out.println(longestSubStr.lengthOfLongestSubstringNew("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        List<Character> newList = new ArrayList<>();
        for(char c : arr){
            int index = findIndex(list, c);
            if(index == -1){
                list.add(c);
            }else{
                if(newList.size() < list.size()){
                    newList.removeAll(newList);
                    newList.addAll(list);
                }
                for(int i = 0; i <= index; i++){
                    list.remove(0);
                }
                list.add(c);
            }
        }
        if(newList.size() < list.size()){
            newList.removeAll(newList);
            newList.addAll(list);
        }

        return newList.size();
    }

    private int findIndex(List<Character> list, char c){
        int res = -1;
        for(int i = 0; i< list.size(); i++){
            if(list.get(i) == c){
                res = i;
            }
        }

        return res;
    }

    public int lengthOfLongestSubstringNew(String s) {
        int res = 0, i = 0, j = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(set.size(), j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }

        return res;
    }
}
