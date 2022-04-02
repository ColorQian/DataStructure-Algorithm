package com.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int[] hash = new int[26];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = i + 1;
        }

        ArrayList<Integer> res = new ArrayList<>();
        int[] used = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1 ||
                    s.charAt(i) - s.charAt(i - 1) == -1 ||
                    s.charAt(i) - s.charAt(i - 1) == 0) {
                if (used[i - 1] == 0) {  // 前一个未被使用过
                    int temp = hash[s.charAt(i) - 'a'] + hash[s.charAt(i - 1) - 'a'];
                    res.add(temp);
                    used[i] = 1;   // 标记当前使用过
                } else {
                    int temp = hash[s.charAt(i) - 'a'] + hash[s.charAt(i - 1) - 'a'];
                    int old = res.remove(res.size() - 1);
                    res.add(temp >= old ? temp : old);
                    used[i] = 1;
                }

            }
        }

        int sum = 0;
        for (int num : res) {
            sum += num;
        }
        System.out.println(sum);
    }
}
