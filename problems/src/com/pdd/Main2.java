package com.pdd;

import java.io.BufferedInputStream;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int k = in.nextInt();
        String ss = in.nextLine();

        String strB = in.nextLine();
        //System.out.println(strB);

        int[] A = new int[strB.length()];
        for (int i = 0; i < strB.length(); i++) {
            if (i + k < strB.length() && strB.charAt(i) - '0' == 1) {
                A[i + k] = 1;
            } else if (i >= k && strB.charAt(i) - '0' == 1) {
                A[i - k] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : A) {
            sb.append(num);
        }
        System.out.println(sb.toString());
    }

}
