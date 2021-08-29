package top.colorfor.stack;

import java.util.Stack;

/**
 *     1.用dist数组存放距离当前位置的距离，用stack存放原始数组temperature的下标
 *     2.用cur指向temperature数组的下标，pre指向stack栈的栈顶元素
 *
 *     3.如果stack不为空，并且当前遍历的数temperature[cur] 大于 栈顶对应的数temperature[stack.peek()]，
 *     就将stack的栈顶元素弹出，存到pre变量中，cur - pre即为与pre的距离dist[pre].之后再将cur压入stack中。
 *     4.如果stack为空，直接将cur压入stack中。
 *
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        
        int[] temperature = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] dist = dailyTemperatures(temperature);
        for (int i : dist) {
            System.out.print(i+" ");
        }

    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] dist = new int[temperatures.length];
        
        Stack<Integer> stack = new Stack<>();

        for (int cur = 0; cur < temperatures.length; cur++) {
            int pre = 0;
            while (!stack.isEmpty() && temperatures[cur] > temperatures[stack.peek()]){
                pre = stack.pop();
                dist[pre] = cur - pre;
            }

            stack.push(cur);
        }
        return dist;
    }
}
