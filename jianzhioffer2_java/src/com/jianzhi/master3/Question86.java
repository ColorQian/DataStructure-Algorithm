package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/M99OJA/
 * 剑指 Offer II 086. 分割回文子字符串
 */
public class Question86 {
    List<List<String>> result;
    List<String> path;
    public String[][] partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        backtracking(s, 0);
        // List<List<String>> 转 String[][]，这里不重要
        String[][] ans = new String[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            ans[i] =  new String[result.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = result.get(i).get(j);
            }
        }
        return ans;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isValid(sub)) {  // 如果当前截取的子串是回文的
                path.add(sub);

                backtracking(s, i + 1);

                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isValid(String sub) {
        if (sub.length() == 1) return true;

        int left = 0;
        int right = sub.length() - 1;

        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
