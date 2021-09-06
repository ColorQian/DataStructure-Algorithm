package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

//分割回文串，雷同于本包下的DivisionPalindrome
public class Test9 {

    List<List<String>> result = new LinkedList<>();
    List<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {

        backtracking(s,0);

        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            if (isValid(s,startIndex,i)){
                String str = s.substring(startIndex,i+1);
                path.add(str);

                backtracking(s,i+1);

                path.remove(path.size() - 1);
            }else {
                continue;
            }
        }
    }

    private boolean isValid(String s, int start, int end) {

        for (int i = start,j = end; start < end;i++,j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }
}
