package com.pdd;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int T = in.nextInt();   // 表示数据的组数
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();  // 表示共有几块瓜田
            int bagSize = in.nextInt();
            int[][] arr = new int[n][3];

            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                arr[i][2] = in.nextInt();
            }

            Arrays.sort(arr, (a, b) -> a[1] - b[1]);

            int result = 0;

            int startDay = 1;
            int lastDay = arr[n - 1][2];
            int j = 0;
            while (startDay <= lastDay && j < n) {
                if (arr[j][0] >= bagSize) {
                    result += bagSize;
                    arr[j][0] -= bagSize;
                    startDay++;
                } else {
                    if (startDay <= arr[j][2]) {
                        result += arr[j][0];
                        j++;
                    }
                }
            }
            System.out.println(result);
            
        }
    }
}
