package top.colorfor.tree;

public class BinaryTree {

    private Node root;

    public void setRoot(Node node){
        this.root = node;
    }

    //前序遍历
    public void prefix(){
        if (this.root != null){
            root.preQuery();
        }else {
            System.out.println("二叉树为空,不能遍历！！！");
        }
    }

    //中序遍历
    public void infix(){
        if (this.root != null){
            root.infixQuery();
        }else {
            System.out.println("二叉树为空,不能遍历！！！");
        }
    }

    //后序遍历
    public void post(){
        if (this.root != null){
            root.postQuery();
        }else {
            System.out.println("二叉树为空,不能遍历！！！");
        }
    }

    //=============main================

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1);
        binaryTree.setRoot(root);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        node3.setRight(node6);

        binaryTree.prefix();
        System.out.println("------------------");
        binaryTree.infix();
        System.out.println("-------------------");
        binaryTree.post();



    }
}
