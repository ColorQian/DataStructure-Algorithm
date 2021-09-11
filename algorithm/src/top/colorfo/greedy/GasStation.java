package top.colorfo.greedy;

/**
 * https://leetcode-cn.com/problems/gas-station/
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalRest = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {

            curSum += (gas[i] - cost[i]);
            totalRest += (gas[i] - cost[i]);

            if (curSum < 0) {   // 当前累加gas[i] - cost[i]的和 curSum一旦小于0
                start = i + 1;  // 起始位置更新为i+1
                curSum = 0;     // curSum从0开始
            }
        }
        if (totalRest < 0) return -1;  // 说明怎么走都不可能跑一圈了
        return start;

    }
}
