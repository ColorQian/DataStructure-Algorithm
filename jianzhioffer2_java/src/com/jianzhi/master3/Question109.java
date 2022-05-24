package com.jianzhi.master3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/zlDJc7/
 * 剑指 Offer II 109. 开密码锁
 *
 * 参考题解: https://labuladong.github.io/algo/4/29/109/
 */
public class Question109 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            String cur = "";
            for (int i = 0; i < size; i++) {
                cur = queue.poll();

                if (deads.contains(cur)) continue;
                if (target.equals(cur)) return step;

                for (int k = 0; k < 4; k++) {
                    String up = plusOne(cur, k);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }

                    String down = minusOne(cur, k);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String cur, int k) {
        char[] chars = cur.toCharArray();
        if (chars[k] == '9') chars[k] = '0';
        else chars[k] = (char) (chars[k] + 1);

        return String.valueOf(chars);
    }

    public String minusOne(String cur, int k) {
        char[] chars = cur.toCharArray();
        if (chars[k] == '0') chars[k] = '9';
        else chars[k] = (char) (chars[k] - 1);

        return String.valueOf(chars);
    }
}
