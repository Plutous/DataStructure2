package wwkstudy.algorithm_;

/**
 * @author 王文凯
 * @version 1.0
 * 快速排序
 */
public class QurtSort {
    public static void main(String[] args) {
        int[] arr = {-3, 5, 3, 6, 9, 7, 8};

        QuickSort(arr, 0, arr.length - 1);//low左下标， hight右下表
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    //快速排序
    public static void QuickSort(int[] array, int low, int hight) {
        //if (array.length < 1 || low < 0 || hight >= array.length || low > hight) return null;
        if (low < hight) {
            int privotpos = partition(array, low, hight);
            QuickSort(array, low, privotpos - 1);//递归呀这是
            QuickSort(array, privotpos + 1, hight);
        }

    }

    public static int partition(int[] array, int low, int hight) {//分区操作
        int privot = array[low];//基准
        while (low < hight) {//交换基准两侧不满足条件的值
            while (low < hight && array[hight] >= privot) --hight;
            array[low] = array[hight];
            while (low < hight && array[low] <= privot) ++low;
            array[hight] = array[low];//不满足条件的low赋给hight
        }
        array[low] = privot;
        return low;
    }


}
