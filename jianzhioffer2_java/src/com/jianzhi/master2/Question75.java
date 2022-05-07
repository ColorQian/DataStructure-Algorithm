package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/0H97ZC/
 * 剑指 Offer II 075. 数组相对排序
 */
public class Question75 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        // 统计arr1中不同数字出现的次数
        for (int num : arr1) {
            count[num]++;
        }

        // 按照arr2的排序规则, 排序arr1
        int i = 0;
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[i++] = num;
                count[num]--;
            }
        }

        // 将未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
        for (int j = 0; j < count.length; j++) {
            while (count[j] > 0) {
                arr1[i++] = j;
                count[j]--;
            }
        }
        return arr1;
    }
}
