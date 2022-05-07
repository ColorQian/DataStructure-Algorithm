package com.jianzhi.master2;

/**
 * 计数排序
 */
public class CountSort {
    public int[] countSortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        // 辅助数组, 用来统计不同num出现的次数
        // 下标对应num, count[num - min] 表示次数
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        int i = 0;
        for (int num = min; num <= max; num++) {
            while (count[num - min] > 0) {
                nums[i++] = num;
                count[num - min]--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        CountSort sort = new CountSort();

        int[] nums = new int[]{2,3,4,2,3,2,1};
        sort.countSortArray(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
