package wwkstudy.hashtable_;

import java.util.HashMap;

/**
 * @author 王文凯
 * @version 1.0
 * 哈希表演示
 * 第29行有bug
 */
public class HashTableDemo {
    public static void main(String[] args) {
//        Emp wwk = new Emp(0, "王文凯");
//        Emp zjl = ;
//        EmpLinkedList empLinkedList = new EmpLinkedList();
//        empLinkedList.add(wwk);
//        empLinkedList.add(zjl);
//        empLinkedList.list();

        //创建一个hashtable
        HashTab hashTab = new HashTab(5);
        hashTab.add(new Emp(0, "王文凯"));
        hashTab.add(new Emp(1, "张家乐"));
        hashTab.add(new Emp(20, "赵英含"));
        hashTab.add(new Emp(15, "饶梦欢"));
        hashTab.add(new Emp(10, "胡瑞"));

        hashTab.list();
        String name = hashTab.findId(1);
        String name0 = hashTab.findId(0);
        //这里有bug，不能删除头结点，懒得改了
        hashTab.delByid(10);
        System.out.println(name0 + " love " + name);

    }
}

//创建hashtable
class HashTab {
    private EmpLinkedList[] empLinkedListArray;//存放链表的数组
    int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];//利用构造器创建存放链表的数组
        //还要把链表放进去,初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();//给每个数组里添加链表
        }
    }

    //添加变量行为
    public void add(Emp emp) {
        //根据员工的id决定添加到哪个数组里
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);//对象放到到相应的数组
    }

    //编写散列函数（取模法）
    public int hashFun(int id) {
        return id % size;
    }

    //list方法（显示）
    public void list() {//遍历哈希表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }

    //寻找id
    public String findId(int id) {
        int res = hashFun(id);//使用散列函数，计算id在第几条链表
        return empLinkedListArray[res].findByid(id);//调用内个链表的查找方法
    }

    //删除id
    public void delByid(int id) {
        int res = hashFun(id);//散列函数计算所在数组链表位置
        int result = empLinkedListArray[res].delByid(id);
        if (result == 1) {
            System.out.println("删除成功！");
        }
    }


}

class Emp {
    public int id;
    public String name;
    public Emp next;//指向下一节点

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id +
                " name=" + name;
    }
}

//创建一个空链表
class EmpLinkedList {
    //头指针，直接指向第一个雇员
    private Emp head;

    public void add(Emp emp) {//尾插法
        if (head == null) {//第一个节点进来，让head指向它
            head = emp;
        } else {
            Emp temp = head;
            while (temp.next != null) {//遍历到尾节点
                temp = temp.next;
            }
            temp.next = emp;
        }
    }

    //遍历链表
    public void list() {
        if (head == null) {//判空
            System.out.println("链表为空！");
            return;
        }
        Emp temp = head;
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;//指针后移
        }
        System.out.println("");
    }

    //通过id寻找key
    public String findByid(int id) {
        if (head == null) {
            System.out.println("被查询id链表为空！！");
            return null;
        }
        Emp temp = head;
        while (temp.id != id) {
            temp = temp.next;
        }
        return temp.name;
    }

    //通过id删除信息（节点）
    public int delByid(int id){
        if (head == null) {
            System.out.println("id不存在");
            return 0;
            //留着等会写
        }
        Emp temp = head;//辅助指针
        while (temp.next != null) {
            if (temp.next.id == id) {
                break;//找到被删除节点的前一个
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("id不存在！");
            return 0;
        }
        temp.next = temp.next.next;//删除节点
        return 1;
    }

}