package com.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,1,3,2,6,7};

        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("-------------------------");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("666", 6);
        map.put("111", 1);
        map.put("333", 3);
        map.put("444", 4);
        map.put("222", 2);
        map.put("777", 7);

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);

            if (queue.size() > 3) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
