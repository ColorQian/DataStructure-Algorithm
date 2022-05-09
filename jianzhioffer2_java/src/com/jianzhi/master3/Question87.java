package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/0on3uN/
 * 剑指 Offer II 087. 复原 IP
 */
public class Question87 {
    List<String> result;
    List<String> path;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        backtracking(s, 0);

        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (path.size() > 4) return;

        if (s.length() == startIndex && path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(path.get(i)).append(".");
            }
            sb.append(path.get(3));
            result.add(sb.toString());
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isValid(sub)) {  // 如果当前的子串符合要求
                path.add(sub);

                backtracking(s, i + 1);

                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isValid(String sub) {
        if (sub.length() > 3) return false;

        if (sub.length() > 1 && sub.charAt(0) == '0') return false;

        int num = Integer.valueOf(sub);
        if (num > 255) return false;

        return true;
    }
}
