package com.baidu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp = m * i;
            int reverseTemp = reverseStr(temp);
            if (reverseTemp > max) max = reverseTemp;
        }
        System.out.println(max);
    }

    private static int reverseStr(int temp) {

        String s = String.valueOf(temp);
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;

            left++;
            right--;
        }
        return Integer.valueOf(String.valueOf(chars));
    }
}
