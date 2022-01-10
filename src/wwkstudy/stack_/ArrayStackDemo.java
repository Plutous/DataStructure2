package wwkstudy.stack_;

/**
 * @author 王文凯
 * @version 1.0
 * 模拟数组实现栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(5);
        arrayStack.push(3);
        arrayStack.push(2);
        arrayStack.push(4);
        arrayStack.push(4);
        arrayStack.list();

    }
}

//定义一个ArrayStack 表示栈
class ArrayStack{
    public int maxSize;//栈的大小
    public int[] stack;//用数组存放数据
    public int top = -1;//栈顶

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;

    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空没数据");
        }
        int value = stack[top];//获取栈顶元素
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        //从栈顶开始显示数据
        if (isEmpty()){
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println(i + ":" + stack[i]);
        }
    }
}
