package top.colorfor.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个数n是不是快乐数
 */
public class IsHappyNumber {

    //获取快乐数的下一个数，比如输入19，输出82
    public int getNextNumber(int n){
        int res = 0;
        while (n > 0){
            int temp = n%10;
            res = res + temp*temp;
            n = n/10;
        }
        return res;
    }

    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNextNumber(n);
        }

        return n==1;
    }

    //main

    public static void main(String[] args) {
        IsHappyNumber happyNumber = new IsHappyNumber();
        int nextNumber = happyNumber.getNextNumber(19);

        System.out.println(nextNumber);
    }
}
