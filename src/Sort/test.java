package Sort;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Integer[] array = {1, 7, 4, 2, 8, 5, 3, 9, 6};

        //冒泡
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i+1; j < array.length; j++) {
//                if (array[i] > array[j]) {
//                    int tmp = array[i];
//                    array[i] = array[j];
//                    array[j] = tmp;
//                }
//            }
//        }


        //选择
//       for (int i = 0; i < array.length; i++) {
//           int min = i;
//           for (int j = i+1; j < array.length; j++) {
//               if (array[min] > array[j]) {
//                   min = j;
//               }
//           }
//           int tmp = array[i];
//           array[i] = array[min];
//           array[min] = tmp;
//       }

        //插入
//        for (int i = 1; i < array.length; i++) {
//            int cur = i;
//           while (cur > 0 & array[cur-1] > array[cur]) {
//               int tmp = array[cur-1];
//               array[cur-1] = array[cur];
//               array[cur] = tmp;
//               cur--;
//           }
//        }

        //快排

        System.out.print(Arrays.toString(array));
    }
}
