package BasicStructure.StackAndQueue;

import BasicStructure.Array.WEArray;

public class ArrayQueue<E> implements Queue<E> {
    private WEArray<E> data;

    public ArrayQueue(int capacity) {
        data = new WEArray(capacity);
    }

    public ArrayQueue() { this(10); }

    @Override
    public void enqueue(E e) { data.addLast(e); }

    @Override
    public E dequeue() { return data.removeFirst(); }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //打印
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d \n", data.getSize(), data.getCapacity()));
        res.append("front [");
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i));
            if (i != data.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail \n");
        return res.toString();
    }
}
