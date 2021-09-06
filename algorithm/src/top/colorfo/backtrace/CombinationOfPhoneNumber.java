package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class CombinationOfPhoneNumber {

    List<String> result = new LinkedList<>();  //用来储存最终的结果
    StringBuilder str = new StringBuilder();  //用来储存最终结果的每一个字符串
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return result;
        }

        //构造一个String[],下标对应字符串
        String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        backtracking(digits,numString,0);//回溯的方法

        return result;
    }

    private void backtracking(String digits, String[] numString, int num) {
        if (num == digits.length()){
            result.add(str.toString());
            return;
        }

        //获取digits数字串的第num个数字
        int index = digits.charAt(num) - '0';

        //数字index对应的字符串
        String string = numString[index];

        for (int i = 0; i < string.length(); i++) {
            str.append(string.charAt(i));//处理

            backtracking(digits,numString,num + 1); //递归，注意num + 1

            str.deleteCharAt(num); //回溯

        }

    }
}
