package com.jianzhi.master2;

/**
 * 归并排序
 */
public class MergeSort {
    public int[] sortArray(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums;
    }

    public void partition(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        // 分治
        partition(nums, left, mid);
        partition(nums, mid + 1, right);

        // 合并排序
        mergeSort(nums, left, mid, right);
    }

    // 将分治得到的子数组，进行合并排序
    private void mergeSort(int[] nums, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tempArr[index++] = nums[i++];
            } else {
                tempArr[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            tempArr[index++] = nums[i++];
        }
        while (j <= right) {
            tempArr[index++] = nums[j++];
        }

        // 覆盖原来的数组
        for (int k = 0; k < tempArr.length; k++) {
            // 注意覆盖时，nums[left + k] 其中left表示一个偏移量
            nums[left + k] = tempArr[k];
        }
    }
}
