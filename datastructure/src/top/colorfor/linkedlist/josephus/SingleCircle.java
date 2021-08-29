package top.colorfor.linkedlist.josephus;

//单向环形链表-约瑟夫环
public class SingleCircle {


    private Boy first;

    /**
     * 将小孩加入约瑟夫环的方法
     * @param num 表示环中结点的个数
     */
    public void add(int num){
        first = null;

        Boy curBoy = null;  //辅助变量，用来帮助小孩进圈
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);

            //当加入第一个小孩时，让其自己成环
            if (i == 1){
                first = boy;  //first始终指向第一个小孩
                first.next = first;
                curBoy = first;
            }

            //新的小孩结点的进圈操作
            curBoy.next = boy;
            curBoy = curBoy.next;
            curBoy.next = first;

        }
    }

    //遍历圈中的小孩结点
    public void list(){

        if (first == null){
            System.out.println("圈中没有小孩结点");
            return;
        }

        Boy cur = first;
        while (true){
            System.out.printf("当前的小孩编号:%d \n",cur.no);
            if (cur.next == first){
                break;
            }
            cur = cur.next;
        }
    }


    /**
     * 小孩出圈的方法
     * @param startNo 从第几个小孩开始数
     * @param count 数几次
     * @param num 圈中小孩的个数
     */
    public void remove(int startNo,int count,int num){
        if (first == null || startNo < 1 || startNo > num){
            System.out.println("参数输入有误！！！");
            return;
        }

        Boy helper = first;//创建一个辅助指针，让其始终位于first指针的前一个

        //先让first移动到startNo处，即开始报数的位置
        for (int i = 1; i <= startNo-1; i++) {
            first = first.next;
        }

        //再让helper 移动到first的前一位
        while (helper.next != first){
            helper = helper.next;
        }

        while (helper != first){

            //开始报数，让helper和first移动到指定位置
            for (int i = 1; i <= count-1; i++) {
                helper = helper.next;
                first = first.next;
            }

            //此时first指向要移除的小孩结点
            System.out.printf("出圈小孩的编号：%d \n",first.no);
            first = first.next;
            helper.next = first;
        }

        System.out.printf("最后出圈小孩的编号：%d \n",first.no);
    }


    //***************写个main方法测试一下*******************

    public static void main(String[] args) {
        SingleCircle singleCircle = new SingleCircle();

        singleCircle.add(5);

        singleCircle.remove(1,2,5);
    }
}
