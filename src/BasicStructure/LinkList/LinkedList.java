package BasicStructure.LinkList;

public class LinkedList<E> {

    private class Node {
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    //9->8->7->6->5->4->3->2->1->0->NULL
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add: 非法的Index");
        }

        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
             preNode = preNode.next;
        }
        preNode.next = new Node(e, preNode.next);
        size++;
    }

    public void addFirst(E e) { add(e, 0); }

    public void addLast(E e) { add(e, size); }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get: 非法的Index");
        }

        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.e;
    }

    public E getFirst() { return  get(0); }

    public E getLast() { return get(size - 1); }

    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set: 非法的Index");
        }
        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.e = e;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set: 非法的Index");
        }
        Node node = dummyHead;
        for (int i = 0; i < index; i++)  {
            node = node.next;
        }
        //方法1
//        Node current = node.next;
//        node.next = current.next;
//        current.next = null;
//        size--;
//        return current.e;

        //方法2
        Node pre = node;
        pre.next = pre.next.next;
        size--;
        return pre.next.e;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean contains(E e) {
        for (Node node = dummyHead.next; node != null; node = node.next) {
            if (node.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() { return size; }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList: size = %d \n", size));

        for(Node node = dummyHead.next ; node != null ; node = node.next)
            res.append(node + "->");
        res.append("NULL");

        return res.toString();
    }
}

/*
* head->...->tail->null
* 在链表的头部添加元素非常简单
* 在链表的尾部添加元素需要循环index-1次获得node
* 链表的next指针为null代表链表结束
* 虚拟头节点
* 改进的链表： 从head端删除元素，从tail端插入元素
*
* */
