package top.colorfor.str;

import java.util.Arrays;

public class RepeatedSubstringKMP {
    
    public int[] getNext(String pattern){
        char[] s = pattern.toCharArray();
        int[] next = new int[s.length];
        int j = -1;
        next[0] = j;

        for (int i = 1; i < s.length; i++) {
            while (j >= 0 && s[i] != s[j+1]){
                j = next[j];  //当前缀和后缀不相等时，j+1前移
            }

            if (s[i] == s[j+1]){  //当前缀和后缀相等时，i,j+1分别后移
                j++;
            }

            next[i] = j;
        }

        return next;
    }

    public boolean isRepeated(String pattern){
        if (pattern.length() == 0){
            return false;
        }

        int[] next = getNext(pattern);
        int len = next.length;

        //利用next数组判断，一个字符串是否可以由它的一个子串重复多次构成
        if (next[len-1] != -1 && len%(len-(next[len-1]+1)) == 0){//核心代码
            return true;
        }

        return false;
    }

    //------------main---------------

    public static void main(String[] args) {
        RepeatedSubstringKMP kmp = new RepeatedSubstringKMP();
        int[] next = kmp.getNext("aabaaf");

        System.out.println(Arrays.toString(next));

        System.out.println(kmp.isRepeated("aabaab"));


    }
}
