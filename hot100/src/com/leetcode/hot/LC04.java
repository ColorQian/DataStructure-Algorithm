package com.leetcode.hot;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 4. 寻找两个正序数组的中位数
 */
public class LC04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] merge = new int[len1 + len2];

        int i = len1 - 1, j = len2 - 1, k = merge.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                merge[k--] = nums1[i--];
            } else {
                merge[k--] = nums2[j--];
            }
        }

        while (i >= 0) {
            merge[k--] = nums1[i--];
        }
        while (j >= 0) {
            merge[k--] = nums2[j--];
        }

        return findMid(merge);
    }

    public double findMid(int[] merge) {
        if (merge.length % 2 == 1) {
            return merge[merge.length / 2] / 1.0;
        }

        int index = merge.length / 2;
        double r = merge[index];
        double l = merge[index - 1];

        return (r + l) / 2.0;
    }
}
