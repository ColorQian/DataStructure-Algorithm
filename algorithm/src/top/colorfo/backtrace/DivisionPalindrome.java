package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目链接：https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class DivisionPalindrome {

    List<List<String>> result = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0) {
            return result;
        }

        backtracking(s,0);

        return result;
    }

    private void backtracking(String s, int startIndex) {

        if (startIndex >= s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            if (isPalindrome(s,startIndex,i)){ //如果s的[startIndex,i]之间是回文串，则加入到path中
                String str = s.substring(startIndex,i+1);
                path.add(str);

                backtracking(s,i+1);  //递归

                path.removeLast(); //回溯

            }else {       //如果不是回文串，进行下一次判断
                continue;
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex,j = endIndex; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }

    //--------------
    public static void main(String[] args) {
        String str = "aab".substring(0,1);  //substring(begin,end),[begin,end),左闭右开
        System.out.println(str);
        System.out.println("aab".substring(1));

        DivisionPalindrome palindrome = new DivisionPalindrome();
        List<List<String>> s = palindrome.partition("aab");
        for (List<String> strings : s) {
            System.out.println(strings);
        }
    }
}
