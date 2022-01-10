package wwkstudy.algorithm_;

import java.util.Arrays;

/**
 * @author 王文凯
 * @version 1.0
 * 希尔排序
 */
public class ShellSoft {
    public static void main(String[] args) {
//        int[] arr = {-3, 5, 3, 6, 9, 7, 8};
//        shellsoft(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }

        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80000000);
        }
        shellsoft(array);
//        Arrays.sort(array);// 自带的排序

    }
    //希尔排序
    public static void shellsoft(int[] arr) {
        if (arr.length > 0) {
            int len = arr.length;
            int gap = len / 2;//分组
            while (gap > 0) {
                for (int i = gap; i < len; i++) {//进行分组的插入排序
                    int temp = arr[i];//指向间隔gap个，同组的内个
                    int index = i - gap;//索引指向第一个元素
                    while (index >= 0 && arr[index] > temp) {//插入排序交换，temp是要插入的数据
                        arr[index + gap] = arr[index];
                        index -= gap;//步长为gap
                    }
                    arr[index + gap] = temp;
                }
                gap /= 2;
            }
        }

    }

}
