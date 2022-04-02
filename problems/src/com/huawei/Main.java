package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int ICCount = in.nextInt();
        int service = in.nextInt();
        in.nextLine();
        String s = in.nextLine();

        //System.out.println(s);
        int[] used = new int[ICCount];
        int row = 0;
        int col = 0;
        int[][] arr = new int[ICCount][4];
        for (int t = 0; t < s.length(); t++) {
            if (s.charAt(t) == ' ') continue;

            if (s.charAt(t) == 'A') {
                for (int i = 0; i < ICCount; i++) {
                    if (used[i] == 1) continue;
                    for (int j = 0; j < 4; j++) {
                        if (arr[i][j] == 0) {
                            arr[i][j] = 1;
                            if (j == 3) used[i] = 1;

                            if (t == s.length() - 1) {
                                row = i + 1;
                                col = j + 1;
                            }
                            i = ICCount;
                            break;

                        }

                    }
                }
            }

            else if (s.charAt(t) == 'B') {
                for (int i = 0; i < ICCount; i++) {
                    if (used[i] == 1) continue;
                    for (int j = 0; j < 4; j++) {
                        if (used[i] == 1 || arr[i][0] == 1) break;
                        if (used[i] == 0 && arr[i][0] == 0) {
                            Arrays.fill(arr[i], 1);
                            used[i] = 1;

                            if (t == s.length() - 1) {
                                row = i + 1;
                                col = 1;
                            }

                            i = ICCount;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(row);
        System.out.println(col);

    }
}
