package Sort;

import java.util.LinkedList;
import java.util.Random;

public class MaxHeap<E extends Comparable> {
    LinkedList<E> data;
    public MaxHeap(){
        data = new LinkedList<>();
    }
    public MaxHeap(E[] arr) {//heapify
        data = new LinkedList<>();
        for (E e : arr) {
            data.add(e);
        }
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return index*2 + 1;
    }
    private int right(int index){
        return index*2 + 2;
    }
    private void swap(int i, int j) {
        E ret = data.get(i);
        data.set(i, data.get(j));
        data.set(j, ret);
    }

    public void add(E e) {
        data.add(e);
        shiftUp(data.size()-1);
    }
    private void shiftUp(int index){//上浮
        if (index == 0) {
            return;
        }
        if (index > 0 && data.get(parent(index)).compareTo( data.get(index)) < 0) {
            swap(parent(index), index);
            index = parent(index);
            shiftUp(index);
        }
    }

    public E getFront() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("empty heap");
        }
        return data.get(0);
    }
    public E extractFront() {
        E ret = getFront();
        swap(0, data.size() - 1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }
    private void shiftDown(int index) {//下浮
        while (left(index) < data.size()) {//左child是叶子节点
            int j = left(index);//默认为左边
            if (j+1 < data.size() && data.get(j+1).compareTo(data.get(j)) > 0) {//右边的大
                j = j+1;
            }
            if (data.get(index).compareTo(data.get(j)) > 0) {
                break;
            }
            swap(index, j);
            index = j;
        }
    }

    //---------------------测试
    private static double testHeap(Integer[] testData, boolean isHeapfi) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapfi) {
            maxHeap = new MaxHeap(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int i = 0; i < testData.length; i++) {
                maxHeap.add(testData[i]);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractFront();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("error");
            }
        }
        System.out.print("success");

        long endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
//        int n = 100;
//        MaxHeap<Integer> maxHeap = new MaxHeap();
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(100));
//        }
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractFront();
//        }
//
//        for (int i = 0; i < n-1; i++) {
//            if (arr[i] < arr[i+1]) {
//                throw new IllegalArgumentException("error heap");
//            }
//        }
//        System.out.print("success");
//        System.out.print(Arrays.toString(arr));

        //-------------测试Heapify

        int n = 100;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
