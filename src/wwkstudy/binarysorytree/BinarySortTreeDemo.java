//package wwkstudy.binarysorytree;
//
///**
// * @author 王文凯
// * @version 1.0
// * CSDN复制的
// */
//public class BinarySortTreeDemo {
//
//    public static void main(String[] args) {
//        int[] arr = {7, 3, 10, 12, 5, 1, 9, 13};
//        binarySortTree bst = new binarySortTree();
//        //循环的添加结点到二叉排序树
//        for (int i = 0; i < arr.length; i++) {
//            bst.add(new Node(arr[i]));
//        }
//
//        //中序遍历二叉排序树
//        System.out.println("中序遍历二叉排序树~");
//        bst.infixOrder(bst.getRoot()); // 1, 3, 5, 7, 9, 10, 12
//
////		System.out.println("测试查找父节点和删除节点");
////		System.out.println(bst.search(3));
////		System.out.println(bst.searchParent(3));
//
//        System.out.println("测试删除");
//        bst.delNode(10);
//        bst.infixOrder(bst.getRoot());
//
//    }
//
//}
//
//
//class binarySortTree {
//    private Node root;
//
//
//    public Node getRoot() {
//        return root;
//    }
//
//    public void setRoot(Node root) {
//        this.root = root;
//    }
//
//    //删除节点
//
//    /**
//     * 分三种情况，删除的是叶子节点，直接通过父节点删除
//     *
//     * @param val
//     */
//    public void delNode(int val) {
//        Node cur = search(val);//返回查找节点
//        Node par = searchParent(val);//返回父节点
//        if (cur == null) {
//            System.out.println("没有该节点");
//            return;
//        }
//        //删除的只有一个根节点，父节点为null
//        if (cur == root && cur.left == null && cur.right == null) {
//            root = null;
//            return;
//        }
//        //删除的根节点只有一个子节点
//        if (cur == root) {
//            if (root.left != null) {
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//            return;
//        }
//        //要删除的是是叶子节点
//        if (cur.left == null && cur.right == null) {
//            if (par.left == cur) {
//                par.left = null;
//            } else {
//                par.right = null;
//            }
//            return;
//        }
//        //左子树找最大的节点代替删除的，右子树找最小的节点代替删除的,任选其一
//        //要删除的是有两颗子树的节点
//        if (cur.left != null && cur.right != null) {
//            Node tar = cur.right;
//            //找右子树最小的节点
//            while (tar.left != null) {
//                tar = tar.left;
//            }
//            delNode(tar.value);//删除那个叶子节点
//            cur.value = tar.value;
//            return;
//        }
//
//        //删除的是由一颗子树的节点
//        if (cur.left != null && par.left == cur) {
//            par.left = cur.left;
//        }
//        if (cur.left != null && par.right == cur) {
//            par.right = cur.left;
//        }
//        if (cur.right != null && par.left == cur) {
//            par.left = cur.right;
//        }
//        if (cur.right != null && par.right == cur) {
//            par.right = cur.right;
//        }
//
//    }
//
//    //递归创建节点,一个要放添加的节点，一个应该放根节点
//    public void add(Node node, Node curnode) {
//        if (root == null) {
//            root = node;
//            return;
//        }
//        if (node.value < curnode.value) {
//            if (curnode.left != null) {
//                add(node, curnode.left);
//            } else {
//                curnode.left = node;
//            }
//
//        } else {
//            if (curnode.right != null) {
//                add(node, curnode.right);
//            } else {
//                curnode.right = node;
//            }
//        }
//
//
//    }
//
//    //非递归创建
//    public void add(Node node) {
//        if (root == null) {
//            root = node;
//            return;
//        }
//        Node par = root;
//        while (true) {
//            if (node.value < par.value) {
//                if (par.left == null) {
//                    par.left = node;
//                    break;
//                } else {
//                    par = par.left;
//                }
//            } else {
//                if (par.right == null) {
//                    par.right = node;
//                    break;
//                } else {
//                    par = par.right;
//                }
//            }
//
//        }
//    }
//
//    //中序遍历
//    public void infixOrder(Node node) {
//        if (root == null) {
//            System.out.println("树为空，无法遍历");
//            return;
//        }
//        if (node.left != null) {
//            infixOrder(node.left);
//        }
//        System.out.println(node);
//        if (node.right != null) {
//            infixOrder(node.right);
//        }
//    }
//
//}
//
//
//class Node {
//    int value;
//    Node left;
//    Node right;
//
//    public Node(int value) {
//        super();
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "Node [value=" + value + "]";
//    }
//
//    //查找要删除的节点
//    public Node search(int value) {
//        if (this.value == value) {//就是当前节点
//            return this;
//        } else if (this.value > value) {//当前值大于要查找的值,向左递归查找
//            if (this.left == null) {//如果左子节点为空
//                return null;
//            }
//            return this.left.search(value);
//        } else {//查找的值比当前值大,向右递归查找
//            if (this.right == null) {
//                return null;
//            }
//            return this.right.search(value);
//        }
//    }
//
//    //查找要删除的父亲节点
//    public Node searchParent(int value) {
//        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
//            return this;
//        } else {
//           if (this.value > value && this.left != null) {//左子树遍历
//               return this.left.searchParent(value);
//           } else  if (this.value <= value && this.right !=null){
//               return this.right.searchParent(value);
//           } else {
//               return null;
//           }
//        }
//    }
//}
//
