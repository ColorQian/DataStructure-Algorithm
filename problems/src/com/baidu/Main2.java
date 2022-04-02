package com.baidu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();

            int res = 1;
            for (int i = 2; i < N / 2; i++) {
                int x = i;

                if (N % x == 0 && (N / x) <= x) break;

                if (N % x == 0) {
                    boolean flag = true;
                    int y = N / x;
                    for (int j = 2; j <= x; j++) {
                        if (x % j == 0 && y % j == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) res++;
                }
            }
            System.out.println(res);
        }
    }

}
