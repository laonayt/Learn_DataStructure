package Sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {1, 7, 4, 2, 8, 5, 3, 9, 6};
        HeapSort heapSort = new HeapSort();
        int[] array2 = heapSort.sort(array);
        System.out.print(Arrays.toString(array2));
    }

    int[] sort(int[] array) {
        int n = array.length;

        for (int i = (n-2)/2; i >= 0; i--) {
            shiftDown(array, i, n-1);
        }

        for (int i = n-1; i >= 1; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            shiftDown(array, 0, i-1);
        }

        return array;
    }


    int parent(int index) {
        return (index-1)/2;
    }
    int leftChild(int index) {
        return index*2 + 1;
    }
    int rightChild(int index) {
        return index*2 + 2;
    }
    void shiftDown(int[] arr, int parent, int size) {
        while (leftChild(parent) < size) {
            int j = leftChild(parent);//默认左孩子最大

            if (j < size && arr[j] < arr[j+1]) {//右大
                j = j+1;
            }
            if (arr[parent] > arr[j]) {
                break;
            }
            int tmp = arr[parent];
            arr[parent] = arr[j];
            arr[j] = tmp;
            parent = j;
        }
    }
}
