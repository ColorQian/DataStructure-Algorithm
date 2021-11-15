package com.programmercarl.str;

public class ReverseWords {
    public String reverseWords(String s) {
        int len = s.length();

        char[] chars = s.toCharArray();
        int left = 0;
        int right = len - 1;

        //去除字符串两端的空格
        while (left <= right && chars[left] == ' ') left++;
        while (left <= right && chars[right] == ' ') right--;

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            int index = right;   //index记录当前right的位置
            while (index >= left && chars[index] != ' ') index--;  //该循环结束，index位于单词的最左边的
            //左边一个位置

            for (int i = index + 1; i <= right; i++) {
                sb.append(chars[i]);  //StringBuilder加入index-right范围内的单词
            }
            if(left <= index) sb.append(" ");  //加入if判断，是为了防止最后一个单词后面也加空格

            while (index >= left && chars[index] == ' ') index--; //去除单词之间的空格

            right = index;

        }
        return sb.toString();
    }
}
