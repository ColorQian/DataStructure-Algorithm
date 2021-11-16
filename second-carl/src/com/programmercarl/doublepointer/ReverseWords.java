package com.programmercarl.doublepointer;

public class ReverseWords {
    public String reverseWords(String s) {

        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();

        //去除字符串两端的空格
        while (left <= right && str[left] == ' ') left++;
        while (right >= left && str[right] == ' ') right--;

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            int index = right;  //记录当前最右边的位置

            while (index >= left && str[index] != ' ') index--;

            for (int i = index + 1; i <= right; i++) {
                sb.append(str[i]);
            }
            if (index >= left) sb.append(' '); //在单词之间加一个空格

            //去除单词之间的空格
            while (index >= left && str[index] == ' ') index--;
            right = index;
        }
        return sb.toString();
    }
}
