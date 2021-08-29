package top.colorfor.stack;

public class StackTest {
    public static void main(String[] args) throws Exception {
        //栈的容量
        int maxSize = 6;

        ArrayForStack stack = new ArrayForStack(maxSize);

        //压栈
        for (int i = 0; i < maxSize; i++) {
            stack.push(i);  //依次压入0 1 2 3 4 5
        }

        //弹栈
        for (int i = 0; i < maxSize; i++) {
            System.out.println(stack.pop());   ////依次弹出5 4 3 2 1 0
        }

    }
}
