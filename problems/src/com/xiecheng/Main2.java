package com.xiecheng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int len = s.length();
        
        StringBuilder startZero = new StringBuilder();
        StringBuilder startOne = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                startZero.append('0');
                startOne.append('1');
            } else {
                startZero.append('1');
                startOne.append('0');
            }
        }

        String zeroStart = startZero.toString();
        String oneStart = startOne.toString();

        int zeroDiffer = 0;
        int oneDiffer = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != zeroStart.charAt(i)) {
                zeroDiffer += i + 1;
            }

            if (s.charAt(i) != oneStart.charAt(i)) {
                oneDiffer += i + 1;
            }

        }

        int min = Math.min(zeroDiffer, oneDiffer);
        System.out.println(min);
    }
}
