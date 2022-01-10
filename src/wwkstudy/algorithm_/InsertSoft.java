package wwkstudy.algorithm_;

/**
 * @author 王文凯
 * @version 1.0
 * 插入排序
 */
public class InsertSoft {
    public static void main(String[] args) {

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 80000000);
//        }
        int[] arr = {-3, -4, -5, 6, 9, 7, 8, 5};
        insertsoft(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);

        }

    }

    //插入排序
    public static void insertsoft(int[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length - 1; i++) { //插入 n-1 次
                int current = array[i + 1];//current是要插入的元素
                int index = i;//从0开始索引（current 前一个元素）
                while (index >= 0 && current < array[index]) { //注意判断判断插入的位置，index记录
                    array[index + 1] = array[index];
                    index--;
                }
                array[index + 1] = current;//要插入的元素放进去
            }

        }
    }
}

// gap缩小增量，gap = arr.length / 2
//先分组，组内交换，在分组进行组内插入排序
//等gap == 1 是分成最后一组，进行最后的插入排序