package BasicStructure.Array;

public class WEArray<E> implements Array<E> {
    private E[] data;
    private int size;

    //有参构造函数
    public WEArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造函数
    public WEArray() {
        this(10);
    }

    @Override
    public void insert(E e, int index) {
        if (size == data.length) {
            resize(size*2);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add: Index 不合法");
        }

        //从index开始往后移一位
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    @Override
    public void addFirst(E e) { insert(e, 0); }

    @Override
    public void addLast(E e) { insert(e, size); }

    @Override
    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("removeAt: Index 不合法");
        }

        E ret = data[index];

        //从index开始往前移一位
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        data[size] = null;

        if (size == data.length/2) {
            resize(size);
        }

        return ret;
    }

    @Override
    public E removeFirst() { return removeAt(0); }

    @Override
    public E removeLast() { return removeAt(size-1); }

    @Override
    public void remove(E e) {
        int index = getIndex(e);
        removeAt(index);
    }

    @Override
    public void removeAll() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add: Index 不合法");
        }
        data[index] = e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get: index 不合法");
        }
        return data[index];
    }

    @Override
    public E getFirst() { return get(0); }

    @Override
    public E getLast() { return get(size-1); }

    @Override
    public int getIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //二分查找
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int begin = 0;
        int end = nums.length;
        while (begin < end) {
            int mid = (end - begin) / 2;

            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target){
                begin = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() { return size; }

    @Override
    public int getCapacity() { return data.length; }

    @Override
    public boolean isEmpty() { return size == 0; }

    //重置大小
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void swap(int i, int j) {
        E ret = data[i];
        data[i] = data[j];
        data[j] = ret;
    }

    //打印
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: Size:%d, Capacity:%d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
}
