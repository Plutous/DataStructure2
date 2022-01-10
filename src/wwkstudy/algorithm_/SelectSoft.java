package wwkstudy.algorithm_;

/**
 * @author 王文凯
 * @version 1.0
 * 选择排序
 */
public class SelectSoft {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000000);
        }

        selectsoft(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }

    }

    //选择排序
    public static void selectsoft(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {//进行 n-1 次排序
            int minIndex = i;
            int min = arr[i];//假定第一个值最小
            for (int j = +1; j < arr.length - 1; j++) {//用来找到最小值
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //和最小值交换
            if (minIndex != i) {//判断是否需要交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}

