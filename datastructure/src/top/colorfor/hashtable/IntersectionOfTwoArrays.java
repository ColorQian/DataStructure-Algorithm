package top.colorfor.hashtable;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class IntersectionOfTwoArrays {

    /**
     * 本题使用的是一个HashSet加一个Stack
     *
     * 本题也可以使用两个HashSet做
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1,int[] nums2){

        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i = 0; i < nums2.length; i++) {

            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[0];
            }

            if (set.contains(nums2[i])){
                stack.push(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int[] res = new int[stack.size()];
        int count = 0;
        while (!stack.isEmpty()){
            res[count++] = stack.pop();
        }

        return res;
    }



    //============main===========

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection1 = intersection.intersection(nums1, nums2);
        for (int i : intersection1) {
            System.out.println(i);
        }

        System.out.println("------------------");


    }
}
