package top.colorfor.stack;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 */
public class SortStackByStack {

   public static Stack sortStack(Stack<Integer> stack){

       Stack<Integer> help = new Stack<>();
       while (!stack.isEmpty()){

           int cur = stack.pop();
           while(!help.isEmpty() && cur > help.peek()){
               stack.push(help.pop());
           }

           help.push(cur);

       }

       while (!help.isEmpty()){
           stack.push(help.pop());
       }

       return stack;
   }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(1);
        stack.push(8);
        stack.push(7);
        stack.push(3);
        stack.push(4);
        stack.push(4);

        stack = sortStack(stack);

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }

    }
}
