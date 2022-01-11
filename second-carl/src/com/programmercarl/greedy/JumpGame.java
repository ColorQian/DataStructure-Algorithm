package com.programmercarl.greedy;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 跳跃游戏
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 0;

        for (int i = 0; i <= cover; i++) {
            int step = i + nums[i];   //step表示下一步跳多远
            if (step > cover) {
                cover = step;     //cover保存当前所能跳的最远距离
            }

            if (cover >= nums.length - 1) return true;  //如果已经可以到达终点，则返回true
        }
        return false;
    }
}
