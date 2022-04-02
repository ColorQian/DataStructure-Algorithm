package com.test;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        if (s == null) return;

        String str = s.substring(2, s.length()); //截取16进制字符串

        int num = 0;
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'a') {
                num += 10 * (Math.pow(16, count));
            } else if (str.charAt(i) == 'b') {
                num += 11 * (Math.pow(16, count));
            } else if (str.charAt(i) == 'c') {
                num += 12 * (Math.pow(16, count));
            } else if (str.charAt(i) == 'd') {
                num += 13 * (Math.pow(16, count));
            } else if (str.charAt(i) == 'e') {
                num += 14 * (Math.pow(16, count));
            } else if (str.charAt(i) == 'f') {
                num += 15 * (Math.pow(16, count));
            } else {
                int cur = str.charAt(i) - '0';
                num += cur * (Math.pow(16, count));
            }
            count++;
        }

        int result = 0;
        String s1 = Integer.toBinaryString(num);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') result++;
        }
        System.out.println(result);
    }
}
