package com.meituan;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int n = in.nextInt();
        int game = in.nextInt();
        int table = in.nextInt();

        int[][] nums = new int[game + table][2];
        for (int i = 0; i < game; i++) {
            nums[i][0] = in.nextInt();
        }
        for (int i = 0; i < game; i++) {
            nums[i][1] = in.nextInt();
        }

        for (int i = game; i < table; i++) {
            nums[i][0] = in.nextInt();
        }
        for (int i = game; i < table; i++) {
            nums[i][1] = in.nextInt();
        }

        Arrays.sort(nums, (a,b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {

            if (nums[i][0] <= list.get(list.size() - 1)[1]) {
                nums[i][1] = Math.min(list.get(list.size() - 1)[1], nums[i][1]);
                list.remove(list.size() - 1);
                list.add(nums[i]);
            } else {
                list.add(nums[i]);
            }
        }

        int result = 0;
        if (!list.isEmpty()) {
            int[] num = list.remove(list.size() - 1);
            result += num[1] - num[0] + 1;
        }
        System.out.println(result);

    }
}
