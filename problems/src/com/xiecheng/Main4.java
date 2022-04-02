package com.xiecheng;


import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int m = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();

        in.nextLine();

        char[][] chars = new char[m][n];

        String str = "";
        for (int i = 0; i < m; i++) {
            str = in.nextLine();
            for (int j = 0; j < str.length(); j++) {
                chars[i][j] = str.charAt(j);
            }
        }

        int[][] operator = new int[q][4];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                operator[i][j] = in.nextInt();
            }
        }

        /*System.out.println(chars[1][2]);
        System.out.println(operator[1][2]);
        System.out.println(operator[1][3]);*/

        for (int i = 0; i < q; i++) {
            reverse(chars, operator, i);
        }

        // https://gitee.com/ColorQian/cloudimages/raw/master/img/
        // G:/aliyunpan/typora/img/

        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars[0].length; j++) {
                sb.append(chars[i][j]);
            }
            System.out.print(sb.toString() + "\n");
        }

    }

    private static void reverse(char[][] chars, int[][] operator, int t) {

        int x1 = operator[t][0] - 1;
        int y1 = operator[t][1] - 1;
        int x2 = operator[t][2] - 1;
        int y2 = operator[t][3] - 1;

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                char c = chars[i][j];
                if (c - 0 <= 90) { //说明c是大写字母，转为小写
                    chars[i][j] = Character.toLowerCase(c);
                } else {
                    chars[i][j] = Character.toUpperCase(c);
                }
            }
        }

    }
}
