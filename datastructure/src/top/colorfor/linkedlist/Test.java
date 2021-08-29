package top.colorfor.linkedlist;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {


            if(i == 1)
                continue; //跳过当前这一次循环，执行下一次循环

            if (i == 5)
                break; //跳出循环，剩下的循环也不执行了

            System.out.println(i);
        }
    }
}
