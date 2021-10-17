package top.colorfo.hot100;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;

        int j = 0;  //相当于一直指向0，将 0 移动到末尾

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { //遍历数组，遇到不为 0 的元素，
                                // 则与 j 所指元素交换，交换完成i++,j++
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
