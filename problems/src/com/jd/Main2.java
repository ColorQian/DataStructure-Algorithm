package com.jd;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] array = new int[n + 1][n + 1];
        for (int t = 0; t < m; t++) {
            int i = in.nextInt();
            int j = in.nextInt();
            int val = in.nextInt();
            array[i][j] = val;
            array[j][i] = val;
        }

        int maxWeight = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            int j = i;
            int count = m - 1;
            while (count > 0) {
                count--;
                temp = Integer.MAX_VALUE;
                        ;
                if (array[j%(n + 1)][(j + 1)%(n + 1)] < temp) {
                    temp = array[j%(n + 1)][(j + 1)%(n + 1)];
                }
                j++;
            }
            if (temp > result) result = temp;
        }
        System.out.println(result);
    }
}
