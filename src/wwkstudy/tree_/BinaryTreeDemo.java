package wwkstudy.tree_;

/**
 * @author 王文凯
 * @version 1.0
 * 二叉树的前序中序后序遍历
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "武松");

        //说明，先手动创建二叉树，后面用递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        binaryTree.setRootnode(root);//把根节点给root
        //前序遍历
        binaryTree.preOrder();
//        //中序遍历
//        binaryTree.infixOrder();
//        //后序遍历
//        binaryTree.postOrder();

//        System.out.println(binaryTree.prevFind(3));

        //节点的删除
        binaryTree.delNode(4);
    }
}

//定义一个树
class BinaryTree {
    private Node rootnode;//根节点

    public void setRootnode(Node rootnode) {
        this.rootnode = rootnode;
    }

    //前序遍历，从树里调用节点方法
    public void preOrder() {
        if (this.rootnode != null) {
            this.rootnode.preOrder();
        }
    }

    //中序遍历，从树里调用节点方法
    public void infixOrder() {
        if (this.rootnode != null) {
            this.rootnode.infixOrder();
        }
    }

    //后序遍历，从树里调用节点方法
    public void postOrder() {
        if (this.rootnode != null) {
            this.rootnode.postOrder();
        }
    }

    //前序查找
    public Node prevFind(int no) {
        return this.rootnode.prevFind(no);
    }

    //删除节点
    public void delNode(int no) {
        if (rootnode == null) {
            System.out.println("树不存在");
        }
        if (rootnode.getNo() == no) {
            this.rootnode = null;
        }
        rootnode.delNode(no);
        System.out.println("删除成功！！！\n");
        rootnode.preOrder();
    }
}

//定义节点
class Node {
    private int no;
    private String name;
    private Node left;//二叉树的左根
    private Node right;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历（遍历代码写在了节点类里，）
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//输出父节点
        //递归向右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //左子树中序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public Node prevFind(int no) {
        if (this.no == no) {//先判断当前节点
            return this;
        }
        //左子树判空，找到节点返回
        Node resnode = null;
        if (this.left != null) {
            resnode = this.left.prevFind(no);
        }
        if (resnode != null) {//说明左子树找到了
            return resnode;
        }
        //右子树判空
        if (this.right != null) {
            resnode = this.right.prevFind(no);
        }
        return resnode;
    }

    //节点的删除(递归删除节点)
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {//判断左子节点
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {//判断右子节点
            this.right = null;
            return;
        }
        if (this.left != null) {//向左递归前序遍历
            this.left.delNode(no);
        }
        if (this.right != null) {//向左没找到，开始向右递归（这里面有个递归回溯问题，可以回到上一层，自己debug）
            this.right.delNode(no);
        }
    }
}
