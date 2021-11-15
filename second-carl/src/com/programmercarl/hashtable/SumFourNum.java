package com.programmercarl.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 */
public class SumFourNum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重的操作

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //去重操作

                int left = j + 1;    //左边的指针
                int right = nums.length - 1;   //右边的指针
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) left++;
                    else if (sum > target) right--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        //去重操作
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;

                        //双指针收缩
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
