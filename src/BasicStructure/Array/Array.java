package BasicStructure.Array;

public interface Array<E> {

    //增
    void addFirst(E e);
    void addLast(E e);
    void insert(E e, int index);

    //删
    E removeFirst();
    E removeLast();
    void remove(E e);
    E removeAt(int index);
    void removeAll();

    //改
    void set(int index, E e);

    //查
    E getFirst();
    E getLast();
    E get(int index);
    int getIndex(E e);
    boolean contains(E e);

    int getSize();//长度
    int getCapacity();//容量
    boolean isEmpty();
}
