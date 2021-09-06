package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

public class Test5 {

    String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new LinkedList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;

        backtracking(digits,0);

        return result;
    }

    private void backtracking(String digits,int count) {

        if (count == digits.length()) {
            result.add(path.toString());
            return;
        }

        int number = digits.charAt(count)-'0';
        String str = numString[number];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));

            backtracking(digits,count+1);

            path.deleteCharAt(count);
        }
    }
}
