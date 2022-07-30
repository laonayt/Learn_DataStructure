package BasicStructure.Heap;

import java.util.*;

public class MaxHeap<E extends Comparable<E> > {
    private ArrayList<E> data;

    public MaxHeap(){
        data = new ArrayList<>();
    }
    public int getSize(){
        return data.size();
    }
    public boolean isEmpty() {
        return data.size() == 0;
    }
    private int parent(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("parent: index error");
        }
        return (index-1)/2;
    }
    private int leftChild(int index) {
        return index*2 + 1;
    }
    private int rightChild(int index) {
        return index*2 + 2;
    }
    private void swap(int index1, int index2) {
        E tmp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, tmp);
    }

    //添加一个元素到数组最后，然后上浮
    public void add(E e) {
        data.add(e);
        siftUp(data.size()-1);
    }

    //取出最大的
    public E extractMax() {
        E ret = data.get(0);
        swap(0, data.size()-1);
        data.remove(data.size()-1);
        siftDown(0);
        return ret;
    }

    //上浮：递归的写法
    private void siftUp(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = parent(index);
        if (data.get(index).compareTo(data.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    //下沉：递归写法
    private void siftDown(int k) {
        if (leftChild(k) >= data.size() || rightChild(k) >= data.size()) {
            return;
        }
        int maxChild;
        if (data.get(leftChild(k)).compareTo(data.get(rightChild(k))) > 0) {
            maxChild = leftChild(k);
        } else {
            maxChild = rightChild(k);
        }
        if (data.get(k).compareTo(data.get(maxChild)) < 0) {
            swap(k, maxChild);
            siftDown(maxChild);
        }
    }

    //下沉：循环的写法
    private void siftDownCircul(int k) {
        while(leftChild(k) < data.size()){
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if( j + 1 < data.size() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 )
                j ++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;
            swap(k, j);
            k = j;
        }
    }

    //上浮：循环的写法
    private void siftUpCircul(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public static void main(String[] args) {
        int n = 10;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0 ; i < n ; i ++)
//            maxHeap.add(i);
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        System.out.print(maxHeap.data);

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)
            arr[i] = maxHeap.extractMax();
//        System.out.print(Arrays.toString(arr));

        for(int i = 1 ; i < n ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("错误的堆");

        System.out.println("Test MaxHeap completed.");
    }
}
/*
 * result: [9, 8, 5, 6, 7, 1, 4, 0, 3, 2]
 * */