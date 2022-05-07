package com.jianzhi.master2;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/xx4gT2/
 * 剑指 Offer II 076. 数组中的第 k 大的数字
 */
public class Question76 {
    public int findKthLargest(int[] nums, int k) {
        // 快速排序, 左闭右闭区间
        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;

        // 寻找一个中间值(随机), 然后比中间值小的放左边, 大的放右边
        // 并返回该中间值
        int pivot = partition(nums, start, end);

        // 递归排序(中间值左边和右边)
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        // 在[start, end]之间取一个随机值
        int random = new Random().nextInt(end - start + 1) + start;

        // 先将下标random对应的值交换到最后一位
        swap(nums, random, end);

        // small指向最后一个比nums[end]小的数(由于上面的交换语句,其实nums[end]就是之前的nums[random])
        int small = start - 1;
        // i 其实也是一个指针, 用来遍历寻找比nums[end]小的数, 然后与small交换
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }

        // 将随机下标换回到small + 1 的位置,然后返回
        small++;
        swap(nums, small, end);
        return small;
    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
