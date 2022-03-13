package cc.codetop;

import java.util.PriorityQueue;

public class PQTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        queue.offer(11);
        queue.poll();
    }
}
