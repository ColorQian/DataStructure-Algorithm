package com.xiecheng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        int num = Integer.valueOf(str);

        int ht = headtail(str);

        System.out.println(ht);
    }

    private static int headtail(String num) {
        int n = Integer.valueOf(num);
        int len = num.length();

        boolean head = false;
        int start = 0;
        for (int i = 1; i <= 9; i++) {
            start = (int) (i * Math.pow(10, len)) + n;
            if (start % 7 == 0) return start;
        }

        int end = 0;
        for (int i = 0; i <= 9; i++) {
            end = n * 10 + i;
            if (end % 7 == 0) return end;
        }

        return n;
    }
}
