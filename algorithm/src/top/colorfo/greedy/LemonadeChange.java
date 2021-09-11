package top.colorfo.greedy;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) five++;

            if (bill == 10) {
                if (five <= 0) return false;
                five--;
                ten++;
            }

            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}
