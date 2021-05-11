package com.we.LinkedList;

public class TestLinkList {
    public static void main(String[] args) {
        testBasicLink();
    }

    private static void testBasicLink() {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addFirst(1);

//        for (int i = 0; i < 10; i++) {
//            linkedList.addFirst(i);
//        }

        System.out.print(linkedList);
    }
}
