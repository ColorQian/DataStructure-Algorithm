package top.colorfor.str;

/**
 * 原作者的题解：
 * 定义[left,right]为需要读取单词的区间
 * 指针left、right定义为在去掉字符串首尾空格后字符串的首尾位置
 * 1.去掉字符串首尾左右空格，移动left、right指针指向去掉空格后的首尾位置。
 * while（left<=right）{
 * 2.从后往前一个个遍历单词，设置index指针，指向right位置，index从后往前遍历，直到遇到空格或者末尾
 * 说明此时已经将其中一个单词遍历完。
 * 3.此时index+1为该单词的首位，遍历字符串[index+1,right]区间，加入到StringBuffer中
 * 4.判断index位置，加入空格：若index位置已经到达头位置了，说明不需要添加空格，否则都需要添加空格隔开单词
 * 5.index继续从后往前遍历，跳过空格直到遇到非空字符，将right指向index的位置执行下一次循环
 * }
 * 6.返回StringBuilder.toString();
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        int left = 0;
        int right = len - 1;
        //去除字符串两端的空格
        while (left < len && ch[left] == ' ') left++;
        while (right >= 0 && ch[right] == ' ') right--;

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            int index = right;   //记录当前最右边的位置
            //从右向左遍历
            while (index >= left && ch[index] != ' ') index--;
            //将index~right范围内的单词加入到StringBuilder
            for (int i = index + 1; i <= right; i++) {
                sb.append(ch[i]);
            }
            //在新加入的单词之间加一个空格
            if (index >= left) sb.append(" ");

            //去除原先字符串的单词之间多余的空格
            while (index >= left && ch[index] == ' ') index--;

            right = index;
        }
        return sb.toString();
    }
}
