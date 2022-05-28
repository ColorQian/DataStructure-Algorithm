package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/H6lPxb/
 * 剑指 Offer II 117. 相似的字符串
 */
public class Question117 {
    // 判断相似字符串的主要方法
    public int numSimilarGroups(String[] strs) {
        int[] fathers = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            fathers[i] = i;
        }

        int group = strs.length;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (similar(strs[i], strs[j]) && union(fathers, i, j)) {
                    group--;
                }
            }
        }
        return group;
    }

    // 判断两个字符串是不是相似
    public boolean similar(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount <= 2;
    }

    // 合并两个子集
    public boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }

        return false;
    }

    // 获取节点 i 的根节点fathers[i]
    public int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }

        return fathers[i];
    }
}
