package com.jianzhioffer2.master;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/submissions/
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class Problem45 {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];
        int count = 0;
        for (int num : nums) {
            strs[count++] = String.valueOf(num);
        }

        /**
         * 如果给定["3","30"]
         * 因为 "330" > "303",
         * 所以排序得到：["30","3"]
         */
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
