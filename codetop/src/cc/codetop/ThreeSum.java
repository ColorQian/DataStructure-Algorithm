package cc.codetop;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        Integer[] array = (Integer[]) list.toArray();

        System.out.println(list); // list默认实现了toString()方法
        System.out.println(list.toString());

        // int[] a = (int[]) array; 不能将Integer[] 强转成 int[]
        System.out.println(array);

        Collections.reverse(list);
        System.out.println(list);

        System.out.println("----------------");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

        linkedList.add(0, 0);
        linkedList.addFirst(-1);
        System.out.println(linkedList);

    }
}
