package com.programmercarl.greedy;

public class GasStation {

    //方法一：暴力求解
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];  //记录剩余油量
            int index = (i + 1) % gas.length;

            while (rest > 0 && index != i) {  //模拟以i为起点跑一圈
                rest += gas[index] - cost[index];
                index = (index + 1) % gas.length;
            }
            //如果以i为起点跑一圈，剩余油量>=0,返回该起点位置
            if (rest >= 0 && index == i) return i;
        }
        return -1;
    }

    //方法二：贪心算法
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int total = 0;
        int curSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];   //记录总的剩余油量
            curSum += gas[i] - cost[i];  //记录当前位置的剩余油量

            if (curSum < 0) {  //如果当前剩余油量为负，则把curSum置为0
                curSum = 0;
                index = i + 1; //起始位置更新为i + 1
            }
        }
        if (total >= 0) return index;
        else return -1;
    }
}
