package top.colorfor.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 获取滑动窗口的最大值，使用双端队列
 */
public class MaxWindow {

    public int[] getMaxWindow(int[] arr,int w){

        int[] res = new int[arr.length-w+1];  // res数组用来放每个滑动窗口的最大值
        LinkedList<Integer> qmax = new LinkedList<>();  //qmax 可以理解为一个双向的队列结构，用来放arr的下标
                                                         //qmax从队列头到队列尾应该是单调递减的
                                                        //qmax的队列头始终保存当前滑动窗口的最大值
        int index = 0;  //res数组的下标
        for (int i = 0; i < arr.length; i++) {

            //当双向递减队列不为空，并且当前的arr[i] 大于等于 arr[队列尾部(下标)]
            //就将队列尾部元素弹出
            while (!qmax.isEmpty() && arr[i] >= arr[qmax.peekLast()]){
                qmax.pollLast();
            }

            //程序走到此处，说明队列为空，或者，arr[i] < arr[qmax.peekLast()]
            //此时将下标i加到队列尾部
            qmax.addLast(i);

            if (qmax.peekFirst() == i-w){  //说明qmax的队列头已经过期了，或者说滑动窗口已经滑动到下一个位置了，必须更新队列头
                qmax.pollFirst();
            }

            if (i >= w-1){  //当i==2,到达第一个滑动窗口，更新res[]
                res[index++] = arr[qmax.peekFirst()];
            }

        }
        return res;

    }

    //------------main-----------
    public static void main(String[] args) {
        MaxWindow window = new MaxWindow();

        int[] arr = {4,3,5,4,3,3,6,7};
        int[] maxWindow = window.getMaxWindow(arr, 3);
        System.out.println(Arrays.toString(maxWindow));
    }
}
