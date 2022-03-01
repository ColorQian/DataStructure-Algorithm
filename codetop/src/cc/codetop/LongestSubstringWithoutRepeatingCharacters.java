package cc.codetop;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {  //如果map包含当前字符
                left = Math.max(left, map.get(s.charAt(i)) + 1); //更新左边的位置
            }
            //不管是否更新left,都要更新s.charAt(i)的位置
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1); //计算最大长度
        }
        return maxLen;
    }
}
