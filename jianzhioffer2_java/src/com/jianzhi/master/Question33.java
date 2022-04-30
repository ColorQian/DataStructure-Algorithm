package com.jianzhi.master;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sfvd7V/
 * 剑指 Offer II 033. 变位词组
 */
public class Question33 {

    /**
     * 1. 将字符串转为字符数组排序, 若是属于一组变位词组, 那么排序后都一样
     * 2. 用一个map统计, key放排序后的字符串, value则是List集合
     * 3. 最后返回结果, 注意这种写法: new ArrayList<>(map.values())
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);

            String sorted = new String(charArr);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
