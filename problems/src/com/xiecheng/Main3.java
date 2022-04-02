package com.xiecheng;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)));
                left = map.get(s.charAt(i));
            }
            map.put(s.charAt(i), i);
            if (map.size() == k) {
                maxLen = i - left + 1;
            }
        }
        System.out.println(maxLen);
    }
}
