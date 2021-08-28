package com.Collection.Study.Set.Study;

public class HashSetExercise {
    public static void main(String[] args) {
        //模拟一个HashSet的底层(HashSet的底层就是HashMap）
        Node[] tables = new Node[16];
        Node ljh = new Node("罗嘉豪", null);
        tables[2] = ljh;
        Node ps = new Node("彭帅", null);
        ljh.next = ps;
        Node xxc = new Node("谢祥聪", null);
        ps.next = xxc;
        Node zlp = new Node("张力鹏", null);
        tables[3] = zlp;
        xxc.next = zlp;
        System.out.println(tables[2]);
    }
}
class Node{
    Object items;
    Node next;

    public Node(Object items, Node next) {
        this.items = items;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "items=" + items +
                ", next=" + next +
                '}';
    }
}