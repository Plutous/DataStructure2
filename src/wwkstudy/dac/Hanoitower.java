package wwkstudy.dac;

/**
 * @author 王文凯
 * 汉诺塔，分治算法
 * @create 2022/1/9,21:19
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');

    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //当 num>=2 时，先把上面的盘从a到b，
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //再把上面的盘从B挪到C
            hanoiTower(num - 1, b, a, c);
        }

    }
}
