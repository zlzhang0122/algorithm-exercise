package com.github.algorithm.combinationofphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的组合
 *
 * @Author: zlzhang0122
 * @Date: 2020/3/1 9:15 AM
 */
public class LetterCombinations {
    private Map<String, String> map = new HashMap<String, String>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args){
        LetterCombinations letterCombinations = new LetterCombinations();
        letterCombinations.letterCombinations2("234");
        for(String s : list){
            System.out.println(s + " ");
        }

        list = letterCombinations.letterCombinations2("234");
        for(String s : list){
            System.out.println(s + " ");
        }
    }

    private List<String> letterCombinations(String digits){
        if(digits != null && digits.length() > 0)
            add("", digits);
        return list;
    }

    private void add(String combi, String item){
        if(item == null || item.length() == 0){
            list.add(combi);
        }else{
            String key = item.substring(0, 1);
            String value = map.get(key);
            for(int i = 0; i < value.length(); i++){
                add(combi + value.charAt(i), item.substring(1));
            }
        }
    }

    private List<String> letterCombinations2(String digits){
        List<String> res = new ArrayList<>();
        char[][] item = new char[8][];
        item[0] = "abc".toCharArray();
        item[1] = "def".toCharArray();
        item[2] = "ghi".toCharArray();
        item[3] = "jkl".toCharArray();
        item[4] = "mno".toCharArray();
        item[5] = "pqrs".toCharArray();
        item[6] = "tuv".toCharArray();
        item[7] = "wxyz".toCharArray();

        if(digits == null || digits.length() == 0){
            return res;
        }else{
            res.add("");
            for(char c : digits.toCharArray()){
                res = addNew(res, item[c-'2']);
            }
        }

        return res;
    }

    private List<String> addNew(List<String> item, char[] array){
        List<String> result = new ArrayList<>();
        for(String s : item){
            for(char c : array){
                result.add(s + c);
            }
        }
        return result;
    }
}
