package cc.codetop;

import java.util.Random;

/**
 * 快速排序
 */
public class A_QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end > start) {   //直到子数组中只有一个数字为止
            int pivot = partition(nums, start, end);

            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        // 选定一个基准值
        int random = new Random().nextInt(end - start + 1) + start;

        //把随机选取下标上的数，交换到最后一位
        swap(nums, random, end);

        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {      // 从小到大排序是 nums[i] < nums[end], 从大到小排序是: nums[i] > nums[end]
                small++;
                swap(nums, i, small);
            }
        }

        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

    public static void main(String[] args) {
        A_QuickSort quickSort = new A_QuickSort();
        int[] nums = new int[]{4,1,5,6,2,7,8,3};
        quickSort.sortArray(nums);
        for (int i : nums) {
            System.out.print(i + "  ");
        }
    }
}
