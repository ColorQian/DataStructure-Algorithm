package com.programmercarl.hashtable;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();

        int number = n;
        while (number != 1) {
            if (hashSet.contains(number)) { //如果HashSet包含number,说明出现了循环，则n不是快乐数
                return false;
            } else {        //如果不包含number,将其加入到HashSet集合中
                hashSet.add(number);
            }
            number = getNumberSquare(number);  //将number替换为它每个位置上的数字的平方和。
        }

        return true;
    }

    //该方法将输入的number替换为它每个位置上的数字的平方和。
    public int getNumberSquare(int number) {
        int result = 0;
        while (number > 0) {
            int n = number % 10;
            result += n * n;
            number = number / 10;
        }
        return result;
    }
}
