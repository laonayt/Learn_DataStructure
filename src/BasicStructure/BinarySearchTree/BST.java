package BasicStructure.BinarySearchTree;

import java.util.*;

public class BST<E extends Comparable<E> > {
    private class Node {
        public E val;
        public Node left;
        public Node right;

        public Node(E e) {
            val = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(e, root);
    }

    //增
    private Node add(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.val) < 0) {
            node.left = add(e, node.left);
        }
        if (e.compareTo(node.val) > 0) {
            node.right = add(e, node.right);
        }
        return node;
    }

    //查
    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }
        if (e == node.val) {
            return true;
        }
        if (e.compareTo(node.val) < 0) {
            return contains(e, node.left);
        }
        if (e.compareTo(node.val) > 0) {
            return contains(e, node.right);
        }
        return false;
    }

    //前序遍历递归写法
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历递归写法
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        System.out.println(node.val);
        midOrder(node.right);
    }

    //后序遍历递归写法
    public void tailOrder() {
        tailOrder(root);
    }

    private void tailOrder(Node node) {
        if (node == null) {
            return;
        }
        tailOrder(node.right);
        System.out.println(node.val);
        tailOrder(node.left);
    }

    //前序遍历非递归写法
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.val);

            //栈先进后出
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
    }

    //层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //查找最小
    public void findSmall() {
        Node small = findSmall(root);
        System.out.println(small.val);
    }

    private Node findSmall(Node node) {
        if (node.left == null) {
            return node;
        }
        return findSmall(node.left);
    }

    //删除最小
    public void deleteSmall() {
        Node node = deleteSmall(root);
    }

    private Node  deleteSmall(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = deleteSmall(node.left);
        return node;
    }

    //删除任意
    public Node delete(E e) {
        Node node = find(e, root);

        if (node.left != null) {
            Node leftNode = node.left;
            Node rightNode = node.right;
//            node.left = null;
//            node.right = null;

            //将left接到right的左子树的最下边
            Node small = findSmall(rightNode);
            small.left = leftNode;

            size--;
            return rightNode;
        }

        Node rightNode = node.right;
        node.left = null;
        node.right = null;
        return rightNode;
    }

    public Node find(E e, Node node) {
        if (node == null) {
            return null;
        }
        if (node.val == e) {
            return node;
        }
        if (e.compareTo(node.val) < 0) {
            return find(e, node.left);
        }
        if (e.compareTo(node.val) > 0) {
            return find(e, node.right);
        }
        return null;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int e : nums) {
            bst.add(e);
        }
//        System.out.print(bst.contains(3));
//        bst.tailOrder();
//        bst.preOrder();
//        bst.preOrderNR();
        bst.levelOrder();
//        bst.findSmall();
//        bst.findBig();

//        bst.preOrder();
//        System.out.print("\n");
////        bst.deleteSmall();
//        bst.delete(5);
//        bst.preOrder();
    }
}

/*
 *                  5
 *                3    6
 *              2   4    8
 * */

/*
 *           6
 *         4   8
 *       3
 *      2
 *
 *
 * */

/*
* 二分搜索树：
* 深度优先遍历：前序、中序、后序 （递归、栈）
* 广度优先遍历：层序 （队列）
*
* 删除：前驱、后继
* */
