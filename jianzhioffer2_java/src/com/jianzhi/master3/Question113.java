package com.jianzhi.master3;

import java.util.*;

/**
 * https://leetcode.cn/problems/QA2IGt/
 * 剑指 Offer II 113. 课程顺序
 */
public class Question113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Map的键表示先修课程, value必须是在键对应的课程之后学习的所有课程
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        // inDegrees 数组表示每个节点的入度
        int[] inDegrees = new int[numCourses];
        for (int[] prereq : prerequisites) {
            // 添加 先修课程 之后 需要学习的所有课程
            graph.get(prereq[1]).add(prereq[0]);
            // 将课程的入度 + 1
            inDegrees[prereq[0]]++;
        }

        // 经过上面的步骤, 已经确定了一个有向图, 以及每个节点的入度
        // 接下来, 使用广度优先算法, 实现拓扑排序

        // 将入度为 0 的节点入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        if (queue.size() == 0) return new int[0];

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order.add(cur);   // 添加到排序结果

            // 将当前课程 后续课程的入度 -1
            for (int next : graph.get(cur)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }

        }

        if (order.size() != numCourses) return new int[0];

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }
}
