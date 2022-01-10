package wwkstudy.tree_;

/**
 * @author 王文凯
 * @version 1.0
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
    }
}

//实现顺序存储二叉树遍历
class ArrBinaryTree {
    private int[] arr;//存储数据节点的数祖(用来存节点的)

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //顺序存储二叉树的前序遍历
    /**
     * @param index 数组的下标
     *              只是用遍历二叉树的方式来遍历数组了
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);//输出当前数组
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}