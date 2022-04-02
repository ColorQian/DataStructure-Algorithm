package com.test;

public class JumpGame2 {
    public int jump(int[] nums) {
        int step = 0;
        int distance = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (distance < i + nums[i]) {
                distance = i + nums[i];
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        JumpGame2 jump = new JumpGame2();
        int[] nums = new int[]{2,3,0,1,4};


        System.out.println(jump.jump(nums));
    }
}
