package top.colorfor.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在队列这种数据结构中，最先插入的元素将是最先被删除的元素；
 * 反之最后插入的元素将是最后被删除的元素，因此队列又称为“先进先出”（FIFO—first in first out）的线性表。
 *
 * Queue用法小结：
 * Queue使用时要尽量避免Collection的add()和remove()方法，
 * 而是要使用offer()来加入元素，使用poll()来获取并移出元素。
 * 它们的优点是通过返回值可以判断成功与否。
 * 而add()和remove()方法在失败的时候会抛出异常。
 * 如果要使用前端而不移出该元素，使用element()或者peek()方法。
 */
public class QueueForStack {
    private Queue<Integer> queue;

    public QueueForStack(){
        //LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
        queue = new LinkedList<>();
    }

    public void push(int val){
        //首先将val加入到队列中，此时，val位于队列的最后一位
        queue.offer(val);

        //获取队列的大小
        int count = queue.size();

        while (count > 1){
            //将当前队列的除val之外的所有元素，先取出队列，再放入队列
            //此时，val就位于队列的首位，那么，就实现了栈的“后进先出”
            queue.offer(queue.poll());
            count--;
        }
    }

    public int pop(){
        return queue.poll();
    }

    public int peek(){
        //查看当前的队列头
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    //编写一个main方法，测试一下
    public static void main(String[] args) {
        QueueForStack queue = new QueueForStack();

        for (int i = 1; i <= 8; i++) {
            queue.push(i);
        }


        for (int i = 0; i < 8; i++) {
            System.out.println(queue.pop());
        }
    }
}
