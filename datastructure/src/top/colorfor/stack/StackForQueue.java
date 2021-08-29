package top.colorfor.stack;

import java.util.Stack;

/**
 * 利用栈实现队列
 */
public class StackForQueue {

    //首先准备两个栈
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    //首先将元素压入第一个栈
    public void push(Integer val){
        in.push(val);
    }

    //将入栈的数据弹出，压入出栈中
    //在这个过程中，必须保证出栈为空
    public void in2out(){
        if (out.isEmpty()){  //如果出栈为空，才操作

            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    //相当于一个出队列的操作
    public int pop(){
        //先将 入栈 中的数据 压入到出栈中，这样，经过栈的两次“先进后出”，就实现了队列的“先进先出”
        in2out();

        return out.pop();
    }

    //查看当前的队列的头
    public int peek(){
        in2out();
        return out.peek();
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }

    //编写一个main方法测试一下结果
    public static void main(String[] args) {
        StackForQueue queue = new StackForQueue();

        for (int i = 1; i <= 8; i++) {
            queue.push(i);
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(queue.pop());
        }

    }
}
