package com.jd;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int tankNum = in.nextInt();
        int b = in.nextInt();    // 单个碉堡的生命值
        int destroy = in.nextInt();  // 单个碉堡的伤害
        int d = in.nextInt();

        int result = 0;
        HashMap<Integer, Integer> diaobao = new HashMap<>();
        for (int i = 1; i <= d; i++) {
            diaobao.put(i, b);  // 将碉堡和生命值放入map
        }

        while (tankNum >= 0 && diaobao.size() != 0) {
            result++;
            // 回合1, 坦克进攻
            int tempTanke = tankNum;
            while (tempTanke >= b && !diaobao.isEmpty()) {
                diaobao.remove(diaobao.size() - 1);
                tempTanke -= b;
            }
            if (diaobao.isEmpty()) break;

            int curTankeCount = 0;
            for (Integer has : diaobao.keySet()) {
                curTankeCount += diaobao.get(has);
            }
            if (tempTanke <= curTankeCount && !diaobao.isEmpty()) {
                int temp = curTankeCount - tempTanke;
                if (temp <= 0) {
                    for (Integer key : diaobao.keySet()) {
                        diaobao.remove(key);
                    }
                } else {
                    for (Integer key : diaobao.keySet()) {
                        diaobao.put(key, temp);
                    }
                }

            }

            // 回合2, 碉堡进攻
            if (!diaobao.isEmpty()) {
                int curDiaoBao = diaobao.size();
                tankNum -= destroy * curDiaoBao;
            }
        }

        if (tankNum >= 0) {
            System.out.println(result);
        }

        if (tankNum < 0 && !diaobao.isEmpty()) {
            System.out.println(-1);
        }


    }
}
