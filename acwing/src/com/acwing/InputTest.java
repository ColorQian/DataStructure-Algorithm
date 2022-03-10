package com.acwing;

import java.util.*;

public class InputTest {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // get first input
        System.out.println("请输入你的名字");
        String name = in.nextLine();

        System.out.println("请输入你的年龄");
        int age = in.nextInt();

        System.out.println("你姓什么?");
        String next = in.next();

        System.out.println("你的名字" + name + "  " + "你的年龄：" + age + "   " + "你姓氏" + next);


    }
}
