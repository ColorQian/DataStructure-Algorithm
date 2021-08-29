package top.colorfor.stack;

import java.util.Stack;

/**
 *
 */
public class MyMinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyMinStack(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int data){
        dataStack.push(data);

        //当minStack为空时，放入data
        if (minStack.isEmpty()){
            minStack.push(data);

        }else {  //当minStack不为空时,如果minStack的栈顶元素大于data时，
                 // 将data放入minStack,此时就能保证,minStack的栈顶元素为dataStack的最小值
            if(minStack.peek() > data){
                minStack.push(data);
            }
        }

    }

    public int pop(){
        if (dataStack.isEmpty()){
            throw new RuntimeException("Your Stack is empty!!!");
        }
        return dataStack.pop();
    }

    public int getMin(){
        if (minStack.isEmpty()){
            throw new RuntimeException("Your Stack is empty!");
        }

        return minStack.peek();
    }

    public boolean isEmpty(){
        return dataStack.isEmpty();
    }


    //编写一个main测试一下
    public static void main(String[] args) {
        MyMinStack stack = new MyMinStack();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(8);
        stack.push(2);
        stack.push(10);

        System.out.println(stack.getMin());
    }
}
