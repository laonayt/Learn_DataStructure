package LeedCode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList();
        this.queue2 = new LinkedList();
    }

    public void push(int x) {
        this.queue1.add(x);
    }

    public int pop() {
        for (int e : this.queue1) {
            this.queue2.add(this.queue1.remove());
        }
        return this.queue2.remove();
    }

    public int top() {
        return this.queue1.peek();
    }

    public boolean empty() {
        return this.queue1.isEmpty();
    }
}