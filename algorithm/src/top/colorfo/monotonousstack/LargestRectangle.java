package top.colorfo.monotonousstack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangle {
    //方法一：单调栈
    public static int largestRectangleArea(int[] height) {
        int[] heights = new int[height.length + 2];
        int len = heights.length;
        //将新数组的首尾分别 补位 0
        heights[0] = 0;
        heights[len - 1] = 0;
        for (int i = 1; i < len - 1; i++) {
            heights[i] = height[i - 1];
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int h = heights[mid];    //注意此处的h = heights[mid],不太好理解!!!
                    int w = i - stack.peek() - 1;
                    result = Math.max(h * w, result);
                }
            }
            stack.push(i);
        }
        return result;
    }

    //----------------------------------
    //方法二：双指针解法(leetcode超时)
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            //向左边找，如果heights[left] >= heights[i] ,则保留，直到遇到 i 左边第一个高度小于i的，结束循环
            for (; left >= 0; left--) {
                if (heights[left] < heights[i]) break;
            }

            //向右边找，如果heights[left] >= heights[i] ,则保留，直到遇到 i 右边第一个高度小于i的，结束循环
            for (; right < len; right++) {
                if (heights[right] < heights[i]) break;
            }
            int h = heights[i];
            int w = right - left - 1;
            result = Math.max(result, h * w);
        }
        return result;
    }

    //---------------
    public static void main(String[] args) {
        int rectangleArea = largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(rectangleArea);
    }
}
