package wwkstudy.stack_;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 王文凯
 * @version 1.0
 * 2021.11.21
 * 实现逆波兰表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //为了方便逆波兰表达式使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1.将逆波兰表达式放到ArrayList
        //2.将ArrayList 传递给一个方法，遍历ArrayList配合栈完成计算
        //3.

        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        System.out.println("计算的结果是=" + calculate(rpnList));

    }

    //第一个逆波兰表达式，数字和运算符依次存放到ArrayList
    public static List<String> getListString(String suffixExpression) {
        //将字符串进行分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个栈
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //正则表达式
            if (item.matches("\\d+")) {//匹配的多位数
                //入栈
                stack.push(item);
            } else {
                //pop两个数，再运算，再入栈
                int num2 = Integer.parseInt(stack.pop());//字符串转成数字
                int num1 = Integer.parseInt(stack.pop());//字符串转成数字
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res + "");//整数转成字符串
            }

        }
        //最后留在栈中的就是结果
        return Integer.parseInt(stack.pop());

    }
}
