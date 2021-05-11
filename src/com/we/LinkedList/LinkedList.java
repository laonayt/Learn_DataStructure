package com.we.LinkedList;

public class LinkedList<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    //0->1->2->3 : addIndex = 2
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add: 非法的Index");
        }

        if (index == 0) {
            addFirst(e);
        }

        Node preNode = head;
        for (int i = 0; i < index; i++) {
             preNode = preNode.next;
        }
        preNode.next = new Node(e);
        size++;
    }

    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        size++;
    }

    public void addLast(E e) {
        add(e, size-1);
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        for(Node cur = head.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
}
