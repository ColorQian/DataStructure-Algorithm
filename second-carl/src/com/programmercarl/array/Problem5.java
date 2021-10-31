package com.programmercarl.array;

public class Problem5 {
    /**
     * 方法一：
     * 暴力查找长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int result = Integer.MAX_VALUE;
        int subLength = 0;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = subLength < result ? subLength : result;
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 方法二：滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int subLength = 0;

        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                subLength = i - j + 1;
                result = subLength < result ? subLength : result;
                sum -= nums[j];
                j++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
