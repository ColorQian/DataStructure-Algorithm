package top.colorfor.str;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 *
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 */
public class ImplementStr {

    public static int strStr(String haystack,String needle){
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        
        int m = a.length;  //haystack字符串的长度
        int n = b.length;  // needle字符串的长度

        // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
        for (int i = 0; i <= m-n; i++) {
            int p = i;
            int q = 0;

            while(q < n && a[p] == b[q]){
                p++;
                q++;
            }

            // 如果能够完全匹配，返回原串的「发起点」下标
            if (q == n){
                return i;
            }
        }

        return -1;
    }

    //----------------------main------------

    public static void main(String[] args) {
        int i = strStr("aabaabaaf", "aabaaf");
        System.out.println(i);

    }
}
