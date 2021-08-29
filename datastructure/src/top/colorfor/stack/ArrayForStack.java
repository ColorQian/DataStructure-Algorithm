package top.colorfor.stack;

public class ArrayForStack {

    private int maxSize;

    private int[] array;

    private int top = -1;

    public ArrayForStack(){

    }

    public ArrayForStack(int maxSize){
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    public boolean isEmpty(){

        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public void push(int num) throws Exception {
        if (isFull()){
            throw  new Exception("栈已经满了，不能继续压栈了");
        }

        array[++top] = num;
    }

    public int pop() throws Exception {

        if (isEmpty()){
            throw new Exception("栈已经空了，不能弹栈");
        }

        int temp;
        temp = array[top--];
        return temp;
    }


}
