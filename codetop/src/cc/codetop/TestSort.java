package cc.codetop;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,4,3};
        Arrays.sort(nums, 2, nums.length);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
