package com.github.algorithm.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zlzhang0122
 * @Date: 2021/12/7 下午10:34
 */
public class CharProcess {
    public static void main(String[] args){
        String str = "A Better Butter";
        CharProcess charProcess = new CharProcess();
        String s = charProcess.getChar(str);
        System.out.println(s);
        System.out.println(s.equalsIgnoreCase("s"));
    }

    public String getChar(String str){
        Map<Character, Integer> res = new LinkedHashMap<>();
        String[] strs = str.split(" ");
        for(String s : strs){
            char[] arrs = s.toCharArray();
            for(char c : arrs){
                if(res.containsKey(c)){
                    int count = res.get(c);
                    res.put(c, count + 1);
                }else {
                    res.put(c, 1);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        boolean flag = false;
        for(Map.Entry<Character, Integer> entry : res.entrySet()){
            if(flag){
                stringBuilder.append(",");
            }else {
                flag = true;
            }
            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
