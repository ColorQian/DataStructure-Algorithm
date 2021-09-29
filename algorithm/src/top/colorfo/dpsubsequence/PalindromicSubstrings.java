package top.colorfo.dpsubsequence;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    //暴力匹配
    public int countSubstrings2(String s) {
        int sum = s.length();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                //如果s的(i,j)这部分是回文子串，则sum+1
                if (isPalindromic(i,j,s)) sum += 1;
            }
        }
        return sum;
    }
    private boolean isPalindromic(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
