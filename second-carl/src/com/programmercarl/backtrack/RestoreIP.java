package com.programmercarl.backtrack;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），
 * 整数之间用 '.' 分隔。
 */
public class RestoreIP {
    List<String> result;
    List<String> path;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        backtracking(s, 0);

        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (path.size() > 4) return; //path里面如果已经存了>4,直接返回

        //如果已经切割到末尾，并且path.size()==4,开始收集结果
        if (startIndex == s.length() && path.size() == 4) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                str.append(path.get(i)).append(".");
            }
            str.append(path.get(3));
            result.add(str.toString());
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (i - startIndex > 2) break;  //剪枝操作
            String sub = s.substring(startIndex, i + 1); //左闭右开，[startIndex,i+1)切割
            if (isValid(sub)) {  //如果sub是合法的[0,255]
                path.add(sub);  //处理切割的结果

                backtracking(s, i + 1); //递归

                path.remove(path.size() - 1); //回溯
            }
        }
    }

    //判断切割的子串是否在[0,255]这个范围
    public boolean isValid(String sub) {
        if (sub.length() > 3) return false;

        if (sub.length() == 1) return true;

        if (sub.charAt(0) == '0' && sub.length() > 1) { //出现先导0的情况
            return false;
        }

        int num = Integer.valueOf(sub);
        if (num > 255) return false;

        return true;
    }
}
