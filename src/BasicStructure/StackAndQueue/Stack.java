package BasicStructure.StackAndQueue;

public interface Stack<E> {
    //入栈
    void push(E e);

    //出栈
    E pop();

    //查看栈顶元素
    E peek();

    int getSize();

    boolean isEmpty();
}

/*
* 队列也是一种线性结构
* 相比数组，栈 操作的是数组的子集
* 只能从一端（栈顶）添加元素，另一端（栈顶）取出元素
* 先进后出（FILO）
* 栈这种数据结构，用户只能操作和查看栈顶元素，不关心中间内容, 时间复杂度 O(1)
* */

/*
* 链表：真正的动态数据结构
* 数据存在节点上
* 如果一个节点的next节点是null，就是最后一个节点
* 丧失了随机访问的能力
* */

/*
* 数组最大优点：支持快速查询
* 链表最大优点：动态
* */

