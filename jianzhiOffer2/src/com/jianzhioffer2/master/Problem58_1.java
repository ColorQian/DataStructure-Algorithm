package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Problem58_1 {
    // 倒序遍历+双指针
    public String reverseWords(String s) {
        s = s.trim();  // 去除单词首尾的空格
        int i = s.length() - 1;
        int j = i;
        StringBuilder res = new StringBuilder();

        //循环的条件是: i 不越界
        while (i >= 0) {
            // i一直后移到空格为止，说明找到单词之间的间隔
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1)).append(" "); // 添加单词
            // 去除单词间多余的空格
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i; // 让指针j指向当前单词的最后一位，为下一次截取单词做准备
        }
        return res.toString().trim();  // 由于添加单词时会有：append(" ")，所以结果要trim()一下
    }
}
