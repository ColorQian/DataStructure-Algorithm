package com.programmercarl.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumThreeNumber {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return list;

            if (i > 0 && nums[i - 1] == nums[i]) continue; //去重
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right-1]) right--;
                    while (right > left && nums[left] == nums[left+1]) left++;

                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}
