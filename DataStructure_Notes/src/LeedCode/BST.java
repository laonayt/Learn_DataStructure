package LeedCode;

import java.util.*;

public class BST {
    TreeNode root;

    public void add(int val) {
        root = add(root, val);
    }
    private TreeNode add(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void levelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};
        BST bst = new BST();
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
//        bst.preOrder();
        bst.levelOrder();
    }

}

/*
*        5
*      3   6
*    2   4   8
*
* */
