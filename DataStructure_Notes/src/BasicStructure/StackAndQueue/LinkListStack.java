package BasicStructure.StackAndQueue;

import BasicStructure.LinkList.LinkedList;

public class LinkListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkListStack() {
        linkedList = new LinkedList();
    }

    @Override
    public void push(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E pop() {
        return linkedList.removeLast();
    }

    @Override
    public E peek() {
        return linkedList.getLast();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.getSize() == 0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();
    }

}
