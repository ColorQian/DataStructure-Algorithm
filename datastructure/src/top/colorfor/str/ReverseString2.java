package top.colorfor.str;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i += 2 * k) {
            //1.每隔 2k 个字符的前 k 个字符进行反转
            if (i + k - 1 <= len - 1) {
                reverse(i, i + k - 1, chars);
                continue;
            }
            //2.剩余字符串小于k个，则将剩余的全部反转
            reverse(i, len - 1, chars);
        }
        return String.valueOf(chars);
    }

    private void reverse(int start, int end, char[] chars) {
        while (start < end) {
            char temp = ' ';
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
