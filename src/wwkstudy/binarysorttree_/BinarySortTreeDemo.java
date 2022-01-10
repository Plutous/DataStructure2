package wwkstudy.binarysorttree_;

/**
 * @author 王文凯
 * @version 1.0
 * 二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }

        binarySortTree.infixOrder();

    }
}

//创建二叉排序树
class BinarySortTree{
    private Node root;

    //添加节点方法
    public void add(Node node){
        if (root == null) {//如果root为空，直接指向node
            root = node;
            return;
        }
        root.add(node);
        System.out.println("添加成功！");
    }
    //中序遍历
    public void infixOrder(){
        if (root == null) {
            System.out.println("二叉树为空！");
        }else {
            root.infixOrder();
        }
    }
}

class Node{
    private int val;
    private Node left;
    private Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "val=" + val ;
    }

    //添加节点（递归）
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //和当前节点比较
        if (node.val < this.val) {
            if (this.left == null) {//左子树如果为空，就直接挂上去
                this.left = node;
            } else {
                //递归向左子树遍历添加
                this.left.add(node);
            }
        } else {//添加的节点值大于当前节点，放在右面
            if (this.right == null) {
                this.right = node;
            } else {
                //递归向右子树遍历添加
                this.right.add(node);
            }
        }
    }

    //中序遍历二叉树
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
}
