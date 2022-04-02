package com.test;

public class MergeSortedArray {
    public void merge(int[] nums1, int[] nums2, int m, int n) {
        if (nums2.length == 0 || n == 0) return;

        int t = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;

        while (j >= 0) {
            while (i >= 0 && nums1[i] > nums2[j]) { //如果是nums1中的数字较大，就先放置nums[i]
                nums1[t] = nums1[i];
                i--;
                t--;

            }
            nums1[t] = nums2[j];
            t--;
            j--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray merge = new MergeSortedArray();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge.merge(nums1, nums2, 3, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
