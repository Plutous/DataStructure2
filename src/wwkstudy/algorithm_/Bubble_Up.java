package wwkstudy.algorithm_;

/**
 * @author 王文凯
 * @version 1.0
 * 冒泡排序
 */
public class Bubble_Up {
    public static void main(String[] args) {//设置辅助变量进行冒泡优化

        int[] arr = {-3,5,3,6,9,7,8};
        boolean flag = false;//标志变量，表示是否进行过交换

        int temp = 0;
        for (int i = 0; i < arr.length -1; i++) {//控制一共排序几次
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {//交换
                    flag = true;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }
            if (flag = true) {//在一次排序中，说明一次交换也没有发生
                break;
            } else {
                flag = false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

        }
    }
}
