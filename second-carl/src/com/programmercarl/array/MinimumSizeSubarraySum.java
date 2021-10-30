package com.programmercarl.array;

public class MinimumSizeSubarraySum {

    //方法一：暴力解法
    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {

            int sum = nums[i];
            if (sum >= target) return 1; //如果当前一个nums[i] 就>=target,直接返回

            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {  //判断遍历过程中，满足条件的累加的和 里面 最小的数组下标差
                    result = result < (j - i + 1) ? result : (j - i + 1);
                    break;     //因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result; //如果不满足条件，返回0
    }

    //方法二:滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int subLength = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        int i = 0;  //滑动窗口的起始位置
        for (int j = 0; j < len; j++) { //滑动窗口的结束位置 j
            sum += nums[j];

            while (sum >= target) {  //当前滑动窗口内的和 >= target, 则更新滑动窗口的起始位置
                subLength = j - i + 1;
                result = result < subLength ? result : subLength;

                sum = sum - nums[i++]; //精髓的一步
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
