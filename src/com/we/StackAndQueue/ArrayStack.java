package com.we.StackAndQueue;

import com.we.Array.WEArray;

public class ArrayStack<E> implements Stack<E> {
    private WEArray<E> data;

    public ArrayStack(int capacity){
        data = new WEArray(capacity);
    }

    public ArrayStack() { this(10); }

    @Override
    public void push(E e) { data.addLast(e); }

    @Override
    public E pop() { return data.removeLast(); }

    @Override
    public E peek() { return data.getLast(); }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getCapacity() {
        return data.getCapacity();
    }

    //打印
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack: size = %d, capacity = %d \n", data.getSize(), data.getCapacity()));
        res.append('[');
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i));
            if (i != data.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top \n");
        return res.toString();
    }


}
