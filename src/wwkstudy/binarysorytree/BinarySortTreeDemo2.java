package wwkstudy.binarysorytree;

/**
 * @author 王文凯
 * @create 2021/12/11,17:26
 * 二叉排序树节点的删除
 */
public class BinarySortTreeDemo2 {
    public static void main(String[] args) {
        Node2 root = new Node2(2);
        Node2 node2 = new Node2(0);
        Node2 node3 = new Node2(1);
        Node2 node4 = new Node2(3);
        BinarySortTree2 binarySortTree2 = new BinarySortTree2(root);
        binarySortTree2.add(node2);
        binarySortTree2.add(node3);
        binarySortTree2.add(node4);

        binarySortTree2.infixOrder();

        binarySortTree2.delBST(node2);


    }

}

class BinarySortTree2 {
    private Node2 rootnode;

    public BinarySortTree2(Node2 rootnode) {
        this.rootnode = rootnode;
    }

    //节点的添加
    public void add(Node2 node) {
        if (rootnode == null) {//判空
            rootnode = node;
        }
        rootnode.add(node);
        System.out.println("添加成功！");
    }

    //中序遍历
    public void infixOrder() {
        if (rootnode == null) {//判空
            return;
        }
        rootnode.infixOrder();
    }

    //子树的删除
    public void delBST(Node2 node) {
        if (rootnode == null) {
            return;
        }
        //留着我写呢
        rootnode.delBST(node);

    }
}

class Node2 {
    private int val;
    private Node2 left;
    private Node2 right;

    public Node2(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "val= " + val;
    }

    //获取根节点的深度
    public int hight() {
        return Math.max(left == null ? 0 : left.hight(), right == null ? 0 : right.hight()) + 1;
    }

    //节点的添加
    public void add(Node2 node) {
        if (node == null) {//判空
            return;
        }
        if (node.val < this.val) {//小于当前节点，向左递归
            if (this.left == null) {//判空
                this.left = node;
            } else {
                this.left.add(node);//向左子树递归添加
            }
        } else {//大于当前节点，向右递归
            if (this.right == null) {//判空
                this.right = node;
            } else {
                this.right.add(node);//向右子树递归添加
            }
        }

    }

    //中序遍历
    public void infixOrder() {
        //左子树遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //删除节点
    public void delBST(Node2 node) {
        if (node.val == this.left.val || node.val == this.right.val) {//找到被删除的节点的父节点
            delNode(this, node);
            return;
        }
        if (node.val < this.val) {//向左递归
            this.left.delBST(node);
        } else {
            this.right.delBST(node);
        }
        System.out.println("节点不存在");
    }

    //节点的删除
    public void delNode(Node2 parent, Node2 node) {
        Node2 curr;
        if (parent.right.val == node.val) {//判断要删除的节点在左面还是右面
            curr = parent.right;
        } else {
            curr = parent.left;
        }
        if (curr.left == null && curr.right == null) {//叶子节点情况
            if (parent.left != null) {
                if (parent.left.val == node.val) {//判断在做还是右
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                parent.right = null;
            }
        }

        if (curr.left == null || curr.right == null) {//存在一棵子树
            if (curr.left == null) {//说明右子树不为空
                if (parent.left != null) {
                    if (parent.left.val == node.val) {//判断在做还是右
                        parent.left = curr.right;
                    } else {
                        parent.right = curr.right;
                    }
                } else {
                    parent.right = curr.right;
                }
            }
        }

    }
}