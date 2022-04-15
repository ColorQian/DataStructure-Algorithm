package com.jianzhioffer2.master;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 剑指 Offer 61. 扑克牌中的顺子
 */
public class Problem61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();

        int max = -1;
        int min = 14;
        for (int num : nums) {
            // 跳过大小王
            if (num == 0) continue;

            // 保存最大 最小值
            max = Math.max(num, max);
            min = Math.min(num, min);

            // 如果有重复元素，返回false
            if (repeat.contains(num)) return false;
            repeat.add(num);
        }

        return max - min < 5;
    }
}
