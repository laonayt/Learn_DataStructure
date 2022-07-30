package LianXi;

import java.util.Arrays;

public class sort {

    public static void main(String[] args) {
        int[] array = {1, 7, 4, 2, 8, 5, 3, 9, 6};
        bubbleSort(array);
//        selectSort(array);
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.print(Arrays.toString(array));
    }

    private static void selectSort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int j = 0; j < end; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
        }
    }
}
