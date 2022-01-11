package com.programmercarl.greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 * 分发饼干
 */
public class AssignCookie {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int count = 0;
        //小饼干满足小的胃口
        for (int i = 0; i < s.length; i++) {
            if (count < g.length && g[count] <= s[i]) { //如果当前的饼干能够满足小孩子的胃口
                result++;  //结果+1
                count++;   //换下一个孩子
            }
        }
        return result;
    }
}
