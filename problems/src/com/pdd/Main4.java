package com.pdd;

import java.io.BufferedInputStream;
import java.util.Scanner;
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            String s = in.nextLine();

            if (n % k != 0) {
                System.out.println(-1);
            }
            
            int[] hash = new int[26];
            for (int j = 0; j < n; j++) {
                hash[s.charAt(j) - 'a']++;
            }

            boolean flag = true;
            for (int count : hash) {
                if (count != 0 && count % k != 0) {
                    flag = false;
                }
            }

            if (flag) {
                System.out.println(s);
            } else {
                System.out.println(s);
            }
            //System.out.println("");
        }
    }
    
}
