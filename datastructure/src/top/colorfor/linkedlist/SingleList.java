package top.colorfor.linkedlist;

public class SingleList {

    //头结点
    private Node head = new Node();

    //为当前单向链表添加一个结点
    public void add(Node node){

        //定义一个临时结点指向头结点
        Node temp = head;

        //一直遍历链表，直到temp.next == null
        while (temp.next != null){
            temp = temp.next;
        }

        //temp.next == null,说明找到了链表的尾部，将node加入链表中
        temp.next = node;
    }

    //按照id修改链表的name
    public void update(Node node){
        if (head.next == null){
            return;
        }

        Node temp = head.next;
        while (temp != null){

            if (temp.id == node.id){
                temp.name = node.name;
                break;
            }
            temp = temp.next;

        }

    }

    //根据id删除节点
    public void delete(int id){
        if (head.next == null){
            return;
        }

        Node temp = head;
        while (temp.next != null){

            if (temp.next.id == id){
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
    }

    //遍历链表
    public void list(){
        if (head.next == null){
            return;
        }

        Node temp = head.next;
        while (temp != null){

            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 按照id编号的大小顺序插入，从小到大
     * @param node
     */
    public void insertById(Node node){

        Node temp = head;
        boolean flag = false;
        while (true){

            //如果temp结点的下一个为空，直接跳出循环,从这里跳出循环flag=false;
            if(temp.next == null){
                break;
            }

            //程序走到这里，说明，temp.next != null
            if (node.id == temp.next.id){

                flag = true;  //从这里跳出循环flag = true
                break;

            }else if(node.id < temp.next.id){
                break;  //从这里跳出循环flag = false;
            }

            //这里不用写出node.id > temp.next.id的情况，
            //因为这种情况会一直遍历到链表的末尾，满足temp.next == null条件后，跳出循环，最后在链表末尾加上node

            temp = temp.next;  //temp 向后移动一位，用来遍历单链表
        }

        if (flag){
            System.out.println("编号已经存在");
        }else {
            //在此处执行结点的插入操作(适用于在head结点后加结点(即temp.next == null)，以及node.id 小于 temp.next.id的情况)
            node.next = temp.next;
            temp.next = node;
        }

    }



    public static void main(String[] args) {
        SingleList list = new SingleList();

        /*list.add(new Node(1,"张三"));
        list.add(new Node(2,"lisi"));
        list.update(new Node(2,"李四"));
        list.add(new Node(3,"王五"));
        list.add(new Node(4,"赵六"));

        list.delete(1);
        list.delete(4);

        list.list();*/

        //*****************上面是增删改查的测试************
        //*****************下面是按顺序插入的测试************

        list.insertById(new Node(3,"王3"));
        list.insertById(new Node(2,"王2"));
        list.insertById(new Node(1,"王1"));
        list.insertById(new Node(5,"王5"));
        list.insertById(new Node(4,"王4"));
        list.insertById(new Node(6,"王6"));

        list.list();


    }

}
