package top.colorfor.array;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
    //旋转数组
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        //将nums[i]中的元素 移动后 放入temp数组中
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }

        //再将temp数组中的值 赋值给nums数组
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }
}
