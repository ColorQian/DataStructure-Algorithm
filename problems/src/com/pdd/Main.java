package com.pdd;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = a[i] - b[i];
            result += temp * temp;
        }
        System.out.println(result);
    }
}
