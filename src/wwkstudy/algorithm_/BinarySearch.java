package wwkstudy.algorithm_;

/**
 * @author 王文凯
 * @version 1.0
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-3, -4, -5, 5, 6, 7, 8, 9};
        int index = binarysearch(arr, -5);
        System.out.println(index);

    }

    //二分查找
    public static int binarysearch(int[] arr, int k) {
        int mid, low = 0;
        int high = arr.length;
        while (low <= high) {
            mid = (high - low) / 2;
            if (k < arr[mid]) {
                high = mid + 1;
            } else if (k > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
