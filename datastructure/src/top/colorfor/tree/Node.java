package top.colorfor.tree;

public class Node {

    private int val;

    private Node left;

    private Node right;

    public Node(int val){
        this.val = val;
    }

    //前序遍历二叉树
    public void preQuery(){
        System.out.println(this);

        if (this.left != null){
            this.left.preQuery();
        }

        if (this.right != null){
            this.right.preQuery();
        }
    }

    //中序遍历二叉树
    public void infixQuery(){
        if (this.left != null){
            this.left.infixQuery();
        }

        System.out.println(this);

        if (this.right != null){
            this.right.infixQuery();
        }
    }

    //后序遍历二叉树
    public void postQuery(){
        if (this.left != null){
            this.left.postQuery();
        }

        if (this.right != null){
            this.right.postQuery();
        }

        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}




