package top.colorfor.stack;

import java.util.Stack;

/**
 * 单调栈——返回最近邻的位置
 *
 * 准备一个栈，记为Stack<integer>,栈中存放的元素是数组的位置，开始stack为空，如果找到每一个位置i左边
 * 和右边离i位置最近且值比arr[i]小的位置，那么需要让stack从栈顶到栈底的位置所代表的值是递减的(也就是从大到小)；
 * 如果找到每一个位置i左边和右边离i位置最近且值比arr[i]大的位置，那么需要让stack从栈顶到栈底的位置所代表的值是递增的。
 * 本题需要解决是前者。
 *     下面举例展示单调栈的使用和求解流程，以arr = {3,4,1,5,6,2,7}为例。
 *     1.初始时，arr = {3,4,1,5,6,2,7},stack为空。
 *     2.遍历arr数组，遍历到arr[0] = 3时，stack为空，直接将0压入stack中，此时，stack中从栈顶到栈底为{0(值为3)}
 *     3.遍历到arr[1]=4时，`arr[1] > arr[stack.peek()]`，将1压入到stack中，此时，stack从栈顶到栈底为
 *     {1(值为4)，0(值为3)}
 *     4.遍历到arr[2] = 1时，如果将下标2压入stack中，会破坏stack从栈顶到栈底所代表的的值是递减的规律，
 *     那么，此时将stack的栈顶元素"1"弹出，位置1左边比它代表的值小的下标即为此时stack栈的栈顶元素"0"，
 *     位置1右边比它代表的值小的下标，即为当前遍历的下标"2"，那么res[1] = {0,2}。此时，stack从栈顶到栈底为{0(值为3)}，
 *     如果将下标2压入stack中，依旧会破坏stack从栈顶到栈底的元素所代表的值是递减的规律，此时将stack的栈顶元素"0"弹出，stack栈已经空了，
 *     位置0左边不存在比它小的数，默认取-1，位置0右边比它代表的值小的下标，即为当前遍历的下标"2"，那么res[0] = {-1,2}。
 *     这时，stack为空，将"2"压入stack中，stack从栈顶到栈底的元素为{2(值为1)}
 *     5.按照此规律继续遍历下去......
 *     6.遍历阶段结束后，stack从栈顶到栈底的元素为{6(值为7),5(值为2),2(值为1)}。
 *     下面清算stack中剩下的元素，将stack的栈顶元素"6"弹出，栈中它的下面位置是5，而由于6位置是清算阶段弹出的，所以res[6] = {5,-1};
 *     弹出5位置，栈中它的下面位置是2,5位置是清算阶段弹出的，所以res[5] = {2,-1};
 *     弹出2位置，栈中它的下面没有位置了,2位置是清算阶段弹出的，所以res[2] = {-1,-1};
 *
 */
public class MonotoneStack2 {

    public static int[][] getNearLessNoRepeat(int[] arr){

        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();

        //遍历阶段
        for (int i = 0; i < arr.length; i++) {

             while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){

                 int popIndex = stack.pop();
                 int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                 res[popIndex][0] = leftLessIndex;
                 res[popIndex][1] = i;
             }
             stack.push(i);
        }

        //开始清算阶段
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }

        return res;
    }

    public static void printArr2(int[][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        int[] arr = {3,4,1,5,6,2,7};

        int[][] res = getNearLessNoRepeat(arr);

        printArr2(res);


    }
}
