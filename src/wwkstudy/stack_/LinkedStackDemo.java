package wwkstudy.stack_;

/**
 * @author 王文凯
 * @version 1.0
 * 使用双向链表来模拟栈
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(4);
        linkedStack.push(6);
        linkedStack.push(5);
        linkedStack.push(3);
        linkedStack.list();
    }


}

class LinkedStack{
    StackNode head = new StackNode();

    //入栈
    public void push(int value){
        StackNode temp = head;//定义一个辅助指针
        while (temp.next != null){//找到尾节点
            temp = temp.next;
        }
        StackNode stackNode = new StackNode(value);
        temp.next = stackNode;
        stackNode.pre = temp;
    }
    //出栈
    public void pop(){
        StackNode temp = head;//定义一个辅助指针
        while (temp.next != null){//找到尾节点
            temp = temp.next;
        }
        temp.pre = null;//删除节点
    }
    //遍历(从后向前)
    public void list(){
        StackNode temp = head;//定义一个辅助指针
        while (temp.next != null){//找到尾节点
            temp = temp.next;
        }
        while (temp != head) {
            System.out.println("" + temp.data);
            temp = temp.pre;//向前遍历
        }

    }

}


class StackNode{
    //需要data存放数据
    public int data;
    public StackNode next;//指向下一节点的指针
    public StackNode pre;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }

    public StackNode() {
    }

    public StackNode(int data) {
        this.data = data;
    }

}

