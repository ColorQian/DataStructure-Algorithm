package com.jianzhioffer2.master;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/submissions/
// 剑指 Offer 38. 字符串的排列
/**
 * 思路分析：
 * 1.使用全排列的思路,找出所有的排列, 因为给定元素可能重复, 所以排列集中包含重复的排列
 * 2.将这些排列全部放入Set中, 这样就可以去除掉那些重复的排列了
 */
public class Problem38 {
    Set<String> result;
    List<Character> path;
    int[] used;
    public String[] permutation(String s) {
        if (s.length() == 0) return new String[0];
        result = new HashSet<>();
        path = new ArrayList<>();
        used = new int[s.length()];

        backtracking(s);

        return result.toArray(new String[result.size()]);
    }

    private void backtracking(String s) {
        if (path.size() == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : path) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i] == 1) continue;   // 如果当前元素使用过，直接跳过

            used[i] = 1;        // 处理节点
            path.add(s.charAt(i));

            backtracking(s);   // 递归

            used[i] = 0;       // 回溯
            path.remove(path.size() - 1);
        }
    }
}
