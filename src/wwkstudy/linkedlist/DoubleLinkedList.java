package wwkstudy.linkedlist;

import org.junit.Test;

/**
 * @author 王文凯
 * @version 1.0
 * 双向链表
 * 2021.11.21
 */
public class DoubleLinkedList {


    //创建head结点
    HeroNode02 head = new HeroNode02(0, "");


    //1.添加英雄方法
    public void addHero02(HeroNode02 heronode) {
        //不改变头节点，定义一个辅助节点temp
        HeroNode02 temp = head;

        while (true) {//while的意义是让temp达到单链表的尾部

            if (temp.next == null) {//temp的下一个节点为空
                break;
            }

            temp = temp.next;//指向下一个节点
        }

        temp.next = heronode;//把英雄结点添加到后面
        heronode.pre = temp;//新节点的pre指向前面
    }
    //1.添加英雄方法（按照序号）
    public void addHero(HeroNode02 heronode) {
        //不改变头节点，定义一个辅助节点temp
        HeroNode02 temp = head;

        while (true) {//while的意义是让temp达到单链表的尾部

            if (temp.next == null) {//temp的下一个节点为空
                break;
            }
            if (temp.no >= heronode.no) {//找到位置，让插入的节点和后序节点连接起来
                heronode.next = temp.next;//让新节点指向后面一个节点
                heronode.next.pre = heronode;
                break;
            }

            temp = temp.next;//指向下一个节点
        }

        temp.next = heronode;//把英雄结点添加到后面

        heronode.pre = temp;//新节点的pre指向前面
    }

    //2.显示链表[遍历]
    public void list02() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！！");
            return;
        }
        //因为头节点不能动，定义一个辅助节点temp
        HeroNode02 temp = head;
        while (true) {

            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            // temp 后移
            temp = temp.next;
        }

    }

    //3.单链表里结点的修改
    public void updatelist02(HeroNode02 newheroNode) {

        if (head.next == null) {//判断是否为空
            System.out.println("链表为空！！");
            return;
        }
        //定义一个辅助结点
        HeroNode02 temp = head;
        while (true) {
            if (temp.next.no == newheroNode.no) {//找到这个节点位置了
                //新结点的名字属性给旧节点
                temp.next.name = newheroNode.name;
                return;
            }
            temp = temp.next;

            if (temp.next == null) {//为空跳出，未找到节点
                break;
            }

        }


    }

    //4.结点的删除
    public void deleteNode02(HeroNode02 delHeroNode) {
        //定义辅助指针
        HeroNode02 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.no == delHeroNode.no) {//找到要删除的结点，此时temp指向被删除的节点
                temp.pre.next = temp.next;
                //如果删除的是最后一个节点就不能执行这句话，否则会空指针异常
                if (temp.next != null) {//加一个判断
                    temp.next.pre = temp.pre;
                }
                return;
            }
            temp = temp.next;
        }
    }

    //5.求单链表中有效节点的个数
    public void getNode02() {
        int count = 0;
        //判断链表是否为空
        if (head.next == null) {
            count = 0;
        }
        //定义一个辅助结点用来遍历
        HeroNode02 temp = head;
        while (true) {

            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            count++;
        }
        System.out.println("有效节点个数:" + count);

    }

    //测试方法
    @Test
    public void TestHeroNode() {

        HeroNode02 heroNode1 = new HeroNode02(1, "武松");
        HeroNode02 heroNode2 = new HeroNode02(2, "武大郎");
        HeroNode02 heroNode3 = new HeroNode02(3, "潘金莲");
        HeroNode02 heroNode4 = new HeroNode02(1, "宋江");
        HeroNode02 heroNode5 = new HeroNode02(4, "潘长江");
        //创建单链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addHero(heroNode1);//按照序号顺序添加
        doubleLinkedList.addHero(heroNode2);
        doubleLinkedList.addHero(heroNode3);

        doubleLinkedList.addHero(heroNode4);
        doubleLinkedList.addHero(heroNode5);
        doubleLinkedList.list02();
        //删除宋江
//        doubleLinkedList.deleteNode02(heroNode4);
        //有效结点个数
        doubleLinkedList.getNode02();

//        doubleLinkedList.list02();

//        HeroNode head2 = new HeroNode(0, "");

    }

}

//定义英雄结点
class HeroNode02 {
    public int no;//编号
    public String name;//名字
    public HeroNode02 next;//next域，指向下一结点
    public HeroNode02 pre;//next域，指向下一结点

    public HeroNode02(int no, String name) {
        this.no = no;
        this.name = name;
    }
    //为了方便显示重写toString

    @Override
    public String toString() {
        return "HeroNode02{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}


