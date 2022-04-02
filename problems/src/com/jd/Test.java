package com.jd;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int spot = sc.nextInt();
        int line = sc.nextInt();

        sc.nextLine();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            String str = sc.nextLine();
            list.add(str);

        }

        for (String str : list) {
            System.out.println(str);
        }
    }
}
