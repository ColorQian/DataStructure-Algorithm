package top.colorfor.linkedlist;

public class Node {

    Integer id;
    String name;

    Node next;

    public Node() {
    }

    public Node(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
