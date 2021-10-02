package top.colorfo.monotonousstack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    //方法一：双指针解法
    public int trap1(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;

        int sum = 0;
        for (int i = 1; i < len - 1; i++) { //第一列和最后一列不接雨水
            int rHeight = 0;
            for (int r = i + 1; r < len; r++) {  //找右边的最高的那一列
                if (height[r] > rHeight) rHeight = height[r];
            }

            int lHeight = 0;
            for (int l = i - 1; l >= 0; l--) {  //找左边最高的那一列
                if (height[l] > lHeight) lHeight = height[l];
            }

            int iheight = Math.min(lHeight, rHeight) - height[i]; //当前列的装水量
            if (iheight > 0) sum += iheight;
        }
        return sum;
    }

    //-------------------

    //方法二：动态规划解法
    public int trap2(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;

        int sum = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 1; i < len; i++) {    //记录左边最高的墙
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {  //记录右边最高的墙
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) { //第一列和最后一列不记录雨水量
            int iHeight = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (iHeight > 0) sum += iHeight;
        }
        return sum;
    }

    //---------
    //方法三：单调栈
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int len = height.length;
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }
    //----------------------------
    public static void main(String[] args) {
        TrappingRainWater rainWater = new TrappingRainWater();
        int trap = rainWater.trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(trap);
    }
}
