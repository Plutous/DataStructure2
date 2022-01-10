package wwkstudy.linkedlist;

import org.junit.Test;

/**
 * @author 王文凯
 * @version 1.0
 * @time 2021.11.20
 * 单链表的添加与删除
 */

public class SingleLinkedList {
    //创建head结点
    HeroNode head = new HeroNode(0, "");


    //1.添加英雄方法（尾插法）
    public void addHero(HeroNode heronode) {
        //不改变头结点，定义一个辅助结点temp
        HeroNode temp = head;

        while (true) {//while的意义是让temp达到单链表的尾部

            if (temp.next == null) {//temp的下一个结点为空
                break;
            }

            temp = temp.next;//指向下一个结点
        }

        temp.next = heronode;//把英雄结点添加到后面

    }

    //2.显示链表[遍历]
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！！");
            return;
        }
        //因为头结点不能动，定义一个辅助结点temp
        HeroNode temp = head;
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
    public void updatelist(HeroNode newheroNode) {

        if (head.next == null) {
            System.out.println("链表为空！！");
            return;
        }
        //定义一个辅助结点
        HeroNode temp = head;
        while (true) {
            if (temp.next.no == newheroNode.no){//找到这个结点位置了
                //新结点的名字属性给旧结点
                temp.next.name = newheroNode.name;
                return;
            }
            temp = temp.next;

            if (temp.next == null) {//为空跳出，未找到结点
                break;
            }

        }


    }

    //4.结点的删除
    public void deleteNode(HeroNode delHeroNode){
        //定义辅助结点
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == delHeroNode.no) {//找到要删除的结点，此时temp指向被删除的节点的前一个
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    //5.求单链表中有效节点的个数
    public void getNode() {
        int count = 0;
        //判断链表是否为空
        if (head.next == null) {
            count = 0;
        }
        //定义一个辅助结点用来遍历
        HeroNode temp = head;
        while (true) {

            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            count++;
        }
        System.out.println("有效结点个数:" + count);

    }
    //测试方法
    @Test
    public void TestHeroNode() {

        HeroNode heroNode = new HeroNode(1, "武松");
        HeroNode heroNode2 = new HeroNode(2, "武大郎");
        HeroNode heroNode3 = new HeroNode(3, "潘金莲");
        HeroNode heroNode4 = new HeroNode(2, "宋江");
        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHero(heroNode);
        singleLinkedList.addHero(heroNode2);
        singleLinkedList.addHero(heroNode3);

        singleLinkedList.updatelist(heroNode4);
//        //删除宋江
//        singleLinkedList.deleteNode(heroNode4);
        //有效结点个数
        singleLinkedList.getNode();

        singleLinkedList.list();

//        HeroNode head2 = new HeroNode(0, "");

    }

}

//定义英雄结点
class HeroNode {
    public int no;//编号
    public String name;//名字
    public HeroNode next;//next域，指向下一结点

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    //为了方便显示重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

