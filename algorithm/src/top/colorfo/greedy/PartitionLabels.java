package top.colorfo.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例： 输入：S = "ababcbacadefegdehijhklij" 输出：[9,7,8]
 * 解释： 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 *
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * https://leetcode-cn.com/problems/partition-labels/submissions/
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new LinkedList<>();

        int[] edge = new int[26];
        int right = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            edge[s.charAt(i) - 'a'] = i;  //找到字符出现的最远下标
        }

        for (int i = 0; i < s.length(); i++) {

            right = Math.max(edge[s.charAt(i) - 'a'],right);

            if (i == right) {            //找到字符出现的最远边界,说明到了划分点
                int partition = right - left + 1;
                left = i + 1;
                result.add(partition);
            }
        }
        return result;
    }
}
