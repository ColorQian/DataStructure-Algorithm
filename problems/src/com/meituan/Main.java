package com.meituan;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int max;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int n = in.nextInt();
        int k1 = in.nextInt();
        int k2 = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        ArrayList<Integer> result = new ArrayList<>();
        //ArrayList<Integer> path = new ArrayList<>();
        int sum = 0;
        max = Integer.MIN_VALUE;

        backtracking(nums, sum, result, 0, k1, k2);

        if (result.size() != 0) {
            System.out.println(result.get(0) + " " + result.size());
        }


    }

    private static void backtracking(int[] nums, int sum,
                                     ArrayList<Integer> result, int startIndex, int k1, int k2) {
        if (sum % k1 == 0 && sum % k2 != 0) {
            if (sum == max) {
                result.add(sum);
            }
            if (sum > max) {
                max = sum;
                result.clear();
                result.add(max);
            }
            //return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i]; //处理节点

            backtracking(nums, sum, result, i + 1, k1, k2);

            sum -= nums[i];  // 回溯
        }
    }
}
