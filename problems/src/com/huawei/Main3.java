package com.huawei;

//import java.util.Random;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= 1 && s.charAt(i) - '0' < 10) {
                list.add(s.charAt(i) - '0');
            }
            else if (s.charAt(i) == 'n') {
                list.add("null");
                i += 2;
            }
        }
        System.out.println(list);

        ArrayList<Integer> ll = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((Integer)list.get(i) > 10) ll.add(0);
            else ll.add((Integer)list.get(i));
        }
        System.out.println(ll);

        TreeNode root = null;
        for (int i = 0; 2 * i + 2 < list.size(); i++) {
            TreeNode cur = new TreeNode((Integer) list.get(i));
            if (i == 0);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode () {}

    public TreeNode (int val) {
        this.val = val;
    }
}
