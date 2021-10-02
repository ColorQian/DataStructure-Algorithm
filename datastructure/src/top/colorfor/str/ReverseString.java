package top.colorfor.str;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {
    //反转字符串
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            char temp = ' ';
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
