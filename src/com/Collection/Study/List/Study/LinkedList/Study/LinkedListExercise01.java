package com.Collection.Study.List.Study.LinkedList.Study;

@SuppressWarnings({"all"})
public class LinkedListExercise01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node ps = new Node("彭帅");
        Node xxc = new Node("谢祥聪");
        Node ljh = new Node("罗家豪");

        ps.next = xxc;
        xxc.next = ljh;
        ljh.prev = xxc;
        xxc.prev = ps;

        Node first = ps;
        Node last = ljh;

        //从头遍历
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //从尾遍历
        System.out.println("---倒序---");
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.prev;
        }
        //添加至中间
        Node zlp = new Node("张力鹏");
        zlp.next = ljh;
        zlp.prev = xxc;
        xxc.next = zlp;
        ljh.prev = zlp;

        first = ps;
        System.out.println("---插入后---");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //从尾遍历
        last = ljh;
        System.out.println("---插入后倒序---");
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.prev;
        }
        //插入到第一个
        Node xq = new Node("小屈");
        first = xq;
        xq.next = ps;
        ps.prev = xq;
        System.out.println("---插入到第一后---");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //从尾遍历
        System.out.println("---插入第一后倒序---");
        last = ljh;
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.prev;
        }
        //插入到最后一个
        Node uzi = new Node("uzi");
        last = uzi;
        uzi.prev = ljh;
        ljh.next = uzi;
        first = xq;
        System.out.println("插入到最后一个");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        System.out.println("插入到最后一个倒序");
        last = uzi;
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.prev;
        }
        //删除
        xxc.next = ljh;
        ljh.prev = xxc;
        first = xq;
        System.out.println("删除后");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //删除第一个
        first = ps;
        System.out.println("删除后第一个后");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //删除最后一个
        last = ljh;
        ljh.next = null;
        first = ps;
        System.out.println("删除最后一个后");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
    }
}

class Node {
    public Object items;
    public Node next;
    public Node prev;

    @Override
    public String toString() {
        return "Node{" +
                "items=" + items +
                '}';
    }

    public Node(Object items) {
        this.items = items;
    }
}