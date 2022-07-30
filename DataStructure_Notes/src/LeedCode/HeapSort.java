package LeedCode;

import java.util.*;

public class HeapSort {
    ArrayList<Integer> data;
    HeapSort() {
        data = new ArrayList<>();
    }

    private void swap(int i, int j) {
        int tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }
    private int parent(int index) {
        return (index-1)/2;
    }
    private int leftChild(int index) {
        return index*2 + 1;
    }
    private int rightChild(int index) {
        return index*2 +2;
    }
    private void shiftDown(int index) {
        if (leftChild(index) >= data.size()) {
            return;
        }
        if (data.get(index) > data.get(leftChild(index))) {
            swap(index, leftChild(index));
            shiftDown(leftChild(index));
        }
        if (data.get(index) > data.get(rightChild(index))) {
            swap(index, rightChild(index));
            shiftDown(rightChild(index));
        }
    }
    private void shiftUp(int index) {
        if (index == 0) {
            return;
        }
        if (data.get(index) < data.get(parent(index))) {
            swap(index, parent(index));
            shiftUp(parent(index));
        } else {
            System.out.print("");
        }
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            data.add(array[i]);
            shiftUp(data.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 2, 8, 5, 3, 9, 6};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.print(heapSort.data);
    }
}
