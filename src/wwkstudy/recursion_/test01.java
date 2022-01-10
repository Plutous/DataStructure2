package wwkstudy.recursion_;

/**
 * @author 王文凯
 * @version 1.0
 * 递归
 */
public class test01 {
    public static void main(String[] args) {
        test(5);
    }

    //定义一个递归
    //代码整洁了，脑子烧掉了
    public static void test(int n) {
        if (n > 2) {
            test(--n);
        }
        System.out.println("n = " + n);
    }
}
