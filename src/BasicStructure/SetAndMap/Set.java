package BasicStructure.SetAndMap;

public interface Set<E> {
    void add(E e);
    void delete(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
/*
* 集合：
* 没有重复元素
*
* */