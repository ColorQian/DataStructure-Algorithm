package com.programmercarl.greedy;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 * 柠檬水找零
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] getMoney = new int[3];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                getMoney[0] += 1;   //表示收到一张5块的
            } else if (bills[i] == 10) {
                getMoney[1] += 1;    //表示收到一张10块的
                if (getMoney[0] > 0) {  //如果还有5块的结余
                    getMoney[0] -= 1;
                } else {
                    return false;
                }
            } else {
                getMoney[2] += 1;   //表示收到20的
                if (getMoney[1] > 0 && getMoney[0] > 0) {  //如果10块、5块还有结余
                    getMoney[1] -= 1;
                    getMoney[0] -= 1;
                } else if (getMoney[0] > 2) {  //如果5块还有三张以上结余
                    getMoney[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
