package Sort;

import tools.Asserts;
import tools.Integers;

public class SelectionSort {
    public static void main(String[] args) {

        Integer[] array = Integers.random(10, 1, 20);

        //注意点：end还是用length - 1，i <= end 吧, 这样取array[end]的时候就比较好取了
        for (int end = array.length - 1; end > 0; end--) {
            //记录下每轮扫描最大的索引值
            int maxIndex = 0;

            for (int i = 1; i <= end; i++) {
                if (array[maxIndex] < array[i]) {
                    maxIndex = i;
                }
            }

            //每轮结束，交换最大的值到尾部
            int tmp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = tmp;
        }

        //判断结果
        Integers.println(array);
//        System.out.print(Integers.isAscOrder(array));
        Asserts.test(Integers.isAscOrder(array));
    }
}

/*
* 选择排序:
*
* */

/*
* 冒泡排序和选择排序很像。
* 冒泡排序是每一轮的交换把最大的交换到最后。
* 选择排序是每一轮的扫描，记录最大的，替换最后一个。
* 优势是，节省了两两交换的效率？
* */