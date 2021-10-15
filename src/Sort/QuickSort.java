package Sort;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {
    public static void main(String[] args) {
        Integer[] array = {1, 7, 4, 2, 8, 5, 3, 9, 6};
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        System.out.print(Arrays.toString(array));
    }


    T[] array;
    QuickSort(T[] array) {
        this.array = array;
    }

    public void sort() {
        sort(0, array.length);
    }
    //左闭右开
    public void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = provitIndex(begin, end);
        sort(begin, mid);
        sort(mid+1, end);
    }
    public int provitIndex(int begin, int end) {
        T val = array[begin];
        end--;

        while (begin < end) {
            while (begin < end) {
                if (array[end].compareTo(val) > 0) {//右边元素比轴点元素大,不变
                    end--;
                } else {//右边元素比轴点元素小，替换
                    array[begin] = array[end];
                    begin++;
                    break;
                }
            }
            while (begin < end) {
                if (array[begin].compareTo(val) < 0) {//左边元素比轴点元素小，不变
                    begin++;
                } else {//左边元素比轴点元素大，
                    array[end] = array[begin];
                    end--;
                    break;
                }
            }
        }
        array[begin] = val;
        return begin;
    }
}
