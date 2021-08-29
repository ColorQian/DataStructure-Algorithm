package top.colorfor.str;

import java.util.Arrays;

/**
 * 使用kmp算法匹配字符串
 */
public class KMPStr {

    public int[] getNext(String pattern){
        char[] s = pattern.toCharArray();
        int[] next = new int[s.length];  //初始化一个next数组
        int j = -1;   //j+1指向前缀起始位置
        next[0] = j;

        for (int i = 1; i < s.length; i++) {  //i指向后缀起始位置,从1 开始

            while(j >= 0 && s[i] != s[j+1]){// 前后缀不相同了
                j = next[j];  //让j+1向前回退
            }

            if(s[i] == s[j+1]){// 找到相同的前后缀
                j++;   //j+1后移一位
            }

            next[i] = j; //将j（前缀的长度）赋给next[i]
        }

        return next;
    }

    public int strStr(String haystack,String needle){
        if (needle.length() == 0){
            return 0;
        }

        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        int j = -1;  // 因为next数组里记录的起始位置为-1

        int[] next = getNext(needle); //获取next数组

        for (int i = 0; i < s.length; i++) {  // 注意i就从0开始
            while (j >= 0 && s[i] != t[j+1]){  // 不匹配
                j = next[j];  //     j 寻找之前匹配的位置
            }

            if (s[i] == t[j+1]){  // 匹配，j和i同时向后移动,i的增加在for循环里
                j++;
            }

            if (j == t.length-1){  // 文本串s里出现了模式串t
                return i - t.length + 1;
            }

        }

        return -1;

    }

    //------------main------------
    public static void main(String[] args) {
        KMPStr kmp = new KMPStr();
        int[] next = kmp.getNext("aabaaf");
        System.out.println(Arrays.toString(next));

        int i = kmp.strStr("aabaabaaf", "aabaaf");
        System.out.println(i);

    }
}
