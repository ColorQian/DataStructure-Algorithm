package com.test;

public class TestMerge {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) return getMidValue(nums2);
        if (n == 0) return getMidValue(nums1);

        int[] merge = new int[m + n];
        for (int i = 0; i < m; i++) {
            merge[i] = nums1[i];
        }
        m--;
        n--;
        int t = merge.length - 1;
        while (n >= 0) {
            while (m >= 0 && nums1[m] >= nums2[n]) {
                merge[t] = nums1[m];
                m--;
                t--;
            }
            merge[t] = nums2[n];
            t--;
            n--;
        }

        return getMidValue(merge);
    }

    private double getMidValue(int[] nums) {
        int len = nums.length;
        double res = 0.0;
        if (len % 2 == 1) {
            res = nums[len / 2];
        } else {
            int mid = len / 2;
            double mid2 = nums[mid];
            double mid1 = nums[mid - 1];
            res = (mid1 + mid2)  / 2;
        }
        return res;
    }


}
