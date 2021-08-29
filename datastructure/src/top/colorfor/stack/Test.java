package top.colorfor.stack;

public class Test {

    public static void main(String[] args) {

        int[] array = {0,1,2,3,4,5,6};

        int num = 5;

        for (int i : array) {
            //System.out.println(i);
        }

        /*System.out.println(array[num--]); //5
        System.out.println(num); //4*/

        /*System.out.println(array[--num]); //4
        System.out.println(num); //4*/

        /**
         * 先进入构造方法，然后给new对象的属性赋值，再回到构造方法，给未被赋值的属性赋值
         */
        TestNew testNew = new TestNew("钱佳乐",23);

        System.out.println(testNew.date);

    }

}
