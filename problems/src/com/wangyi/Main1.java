package com.wangyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int monster1 = in.nextInt();
        int monster2 = in.nextInt();

        int single = in.nextInt();
        int both = in.nextInt();

        int result = 0;
        while (monster1 > 0 || monster2 > 0) {
            // 当怪物的血量还够 被 单体击杀， 并且 单体击杀伤害更高
            if ((monster1 >= single || monster2 >= single) && single >= both * 2) {
                if (monster1 >= single) {
                    monster1 -= single;
                    result++;
                }
                if (monster2 >= single) {
                    monster2 -= single;
                    result++;
                }

                if (monster1 <= 0 && monster2 <= 0) break;
            }

            if (single > both * 2) {
                if (monster1 > 0) {
                    monster1 -= single;
                    result++;
                }
                if (monster2 > 0) {
                    monster2 -= single;
                    result++;
                }

                if (monster1 <= 0 && monster2 <= 0) break;
            }

            monster1 -= both;
            monster2 -= both;
            result++;


        }

        System.out.println(result);
    }
}
