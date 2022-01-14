package com.programmercarl.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排(身高相同k小的站前面)
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o2[0] - o1[0];
        });

        /**
         * 按照身高排序之后，优先按身高高的people的k来插入，
         * 后序插入节点也不会影响前面已经插入的节点，最终按照k的规则完成了队列。
         */
        ArrayList<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            /**
             * 将指定的元素插入到此列表中的指定位置。
             * 将当前位置的元素(如果有的话)和随后的元素向右移动(给它们的下标加1)。
             */
            queue.add(person[1], person);
        }
        return queue.toArray(new int[people.length][2]);
    }
}
