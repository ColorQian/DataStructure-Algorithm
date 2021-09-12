package top.colorfo.greedy;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1: 输入: N = 10 输出: 9
 *
 * 示例 2: 输入: N = 1234 输出: 1234
 *
 * 示例 3: 输入: N = 332 输出: 299
 *
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 */
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {

        String str = String.valueOf(n); //将n转为String串
        char[] s = str.toCharArray();

        // flag用来标记赋值9从哪里开始
        // 设置为这个默认值，为了防止第二个for循环在flag没有被赋值的情况下执行
        int flag = str.length();

        for (int i = s.length - 1; i > 0; i--) {
            if (s[i - 1] > s[i]) {
                flag = i;
                s[i - 1] = (char) (s[i - 1] - 1); //s[i - 1]  -> int (转为int类型)
            }
        }

        for (; flag < s.length; flag++) {  //将下标flag及其后面的数，全部置为'9'
            s[flag] = '9';
        }
        String result = String.valueOf(s);
        return Integer.parseInt(result);

    }
    //----------------
    public static void main(String[] args) {
        MonotoneIncreasingDigits num = new MonotoneIncreasingDigits();
        int i = num.monotoneIncreasingDigits(318); //322
        System.out.println(i);
    }
}
