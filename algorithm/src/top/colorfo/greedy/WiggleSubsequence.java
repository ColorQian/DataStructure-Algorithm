package top.colorfo.greedy;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 示例 2: 输入: [1,17,5,10,13,15,10,5,16,8] 输出: 7 解释: 这个序列包含几个长度为 7 摆动序列，
 * 其中一个可为[1,17,10,13,10,16,8]。
 *
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 0) return nums.length;

        int preDiff = 0;
        int curDiff = 0;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i+1] - nums[i];

            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
