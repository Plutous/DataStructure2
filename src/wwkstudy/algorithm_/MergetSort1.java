package wwkstudy.algorithm_;

import java.util.Arrays;

/**
 * @author 王文凯
 * @version 1.0
 * 归并排序
 */
//还没调试好
public class MergetSort1 {
    public static void main(String[] args) {
        int[] arr = {-3, -4, -5, 6, 9, 7, 8, 2};
        int[] newarr = MergeSort(arr);
        for (int i = 0; i < newarr.length - 1; i++) {
            System.out.print(newarr[i]);

        }
    }

    public static int[] MergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;//找到中间索引值
        int[] left = Arrays.copyOfRange(array, 0, mid);//数组通过拷贝分为两半，
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));//通过递归，每一次都是返回 治好的数组，然后再两两治。
        //向左向右递归分解
    }

    public static int[] merge(int[] left, int[] right) {//治，双指针思想
        int[] result = new int[left.length + right.length];//用来保存排序后的数组
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;//

    }
}

