package top.colorfo.monotonousstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        //将nums1的下标，元素放入map中
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                if (map.containsKey(nums2[stack.peek()])) {  //看一下nums1中是否包含这个元素
                    int index = map.get(nums2[stack.peek()]); //获取该元素在nums1中的下标
                    result[index] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
