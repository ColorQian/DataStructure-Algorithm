package com.programmercarl.greedy;

/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 */
public class IncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        //先将int n转换为 char[] 类型的数组,方便后续处理
        String number = String.valueOf(n);
        char[] strNum = number.toCharArray();

        // flag用来标记赋值'9'从哪里开始
        int flag = strNum.length;
        for (int i = strNum.length - 1; i >= 1; i--) {  //一定要从后先前遍历
            if (strNum[i - 1] > strNum[i]) {  //遇到局部递减的情况,就将strNum[i - 1]--,并且标记需要赋值'9'的位置
                strNum[i - 1]--;
                flag = i;
            }
        }

        //将需要赋值'9'的位置，全部赋值为9
        for (int i = flag; i < strNum.length; i++) {
            strNum[i] = '9';
        }

        //最后把char[] -> String -> Integer,将结果返回
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strNum.length; i++) {
            result.append(strNum[i]);
        }
        return Integer.valueOf(result.toString());
    }
}
