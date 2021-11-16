package com.programmercarl.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumFourNumber {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) return list;

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;

                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) left++;
                    else if (sum > target) right--;
                    else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
