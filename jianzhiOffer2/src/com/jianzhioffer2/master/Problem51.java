package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 剑指 Offer 51. 数组中的逆序对
 */
public class Problem51 {
    int count;
    public int reversePairs(int[] nums) {
        if (nums.length <= 1) return 0;

        partition(nums, 0, nums.length - 1);
        return count;
    }

    public void partition(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        // 分治
        partition(nums, left, mid);
        partition(nums, mid + 1, right);

        // 合并排序后的子数组
        mergeSort(nums, left, mid, right);
    }

    // 将nums 看做，两个部分，然后这两个子数组，已经是有序的，该方法就是将两个有序子数组合并为一个数组
    public void mergeSort(int[] nums, int left, int mid, int right) {
        // 临时存储合并后的数组
        int[] tempArr = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;

        // 将有序的两个子数组，按序放入临时数组
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tempArr[index++] = nums[i++];
            } else {
                // 统计逆序对个数
                count += mid - i + 1;        //****此题就比归并排序多了这一行代码****

                tempArr[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            tempArr[index++] = nums[i++];
        }
        while (j <= right) {
            tempArr[index++] = nums[j++];
        }

        // 用临时数组，覆盖原来的数组
        for (int k = 0; k < tempArr.length; k++) {
            nums[left + k] = tempArr[k];
        }
    }
}
