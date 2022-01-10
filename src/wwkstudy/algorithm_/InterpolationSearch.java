package wwkstudy.algorithm_;

/**
 * @author 王文凯
 * @version 1.0
 * 插值查找
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {-3, -4, -5, 5, 6, 7, 8, 9};
        System.out.println(interpolationSearch(arr, 5));

    }

    public static int interpolationSearch(int[] a, int key) {
        int low, mid, high;
        low = 0;// 最小下标
        high = a.length - 1;// 最大小标
        while (low < high) {
            mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);//算法优化过的mid下标
            //mid = (high + low) / 2;// 折半下标
            if (key > a[mid]) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (key < a[mid]) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }
}
