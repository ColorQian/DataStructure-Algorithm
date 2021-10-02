package top.colorfor.str;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class RotateStr {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        String str1 = s.substring(0, n);
        String str2 = s.substring(n, len);
        return str2 + str1;
    }
}
