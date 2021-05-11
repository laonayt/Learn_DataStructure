package com.we.StackAndQueue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int size;//元素个数
    private int front;//队首
    private int tail;//队尾

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() { this(10); }


    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {//满了
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() /4 && getCapacity() / 2 != 0) {
            resize(getCapacity() /2 );
        }

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Empty Queue");

        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    //loop queue会浪费一个空间，不能让队头和队尾相遇。
    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
