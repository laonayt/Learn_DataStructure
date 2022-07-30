package BasicStructure.StackAndQueue;

public interface Queue<E> {
    //入队
    void enqueue(E e);

    //出队
    E dequeue();

    //查看队首元素
    E getFront();

    int getSize();

    boolean isEmpty();
}

/*
 * 队列也是一种线性结构
 * 相比数组，队列操作的是数组的子集
 * 只能从一端（队尾）添加元素，另一端（队首）取出元素
 * 先进先出（FIFO）
 * 链表是非常好的递归选择
 * */

/*
* 数组队列：出队的时间复杂度O(n^2)?
* 循环队列：时间复杂度O(1)
* 链表队列：出队的时间复杂度O(1)
* */