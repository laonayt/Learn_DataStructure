package BasicStructure.SetAndMap;

public class BSTMap<K extends Comparable,V> implements Map<K,V> {
    private class TreeNode {
        K key;
        V value;
        TreeNode left;
        TreeNode right;
        TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private TreeNode rootNode;
    int size;

    public void preOrder() {
        preOrder(rootNode);
    }
    private TreeNode preOrder(TreeNode node) {
        if (node == null) {
            return null;
        }
        System.out.print(String.format("{%s : %s}", node.key.toString(), node.value.toString()) + "->");
        node.left = preOrder(node.left);
        node.right = preOrder(node.right);
        return node;
    }

    @Override
    public void set(K key, V val) {
        rootNode = set(key, val, rootNode);
    }
    private TreeNode set(K key, V val, TreeNode node) {
        if (node == null) {
            size++;
            return new TreeNode(key, val);
        } else {
            if (key.compareTo(node.key) < 0) {
                node.left = set(key, val, node.left);
            } else if (key.compareTo(node.key) > 0) {
                node.right = set(key, val, node.right);
            }
            return node;
        }
    }

    @Override
    public V get(K key) {
        return get(key, rootNode).value;
    }
    private TreeNode get(K key, TreeNode node) {
        if (key.equals(node.key)) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node = get(key, node.left);
        }
        if (key.compareTo(node.key) > 0) {
            node = get(key, node.right);
        }
        return node;
    }
    //测试用的
    public void printSmall() {
        getSmall(rootNode);
    }
    private TreeNode getSmall(TreeNode node) {
        if (node.left != null) {
            return getSmall(node.left);
        }
        System.out.print("smallest:" + node.key.toString());
        return node;
    }
    public void removeSmall() {
        rootNode = removeSmall(rootNode);
    }
    private TreeNode removeSmall(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            size--;
            return right;
        }
        TreeNode dd = removeSmall(node.left);
        node.left = dd;
        return node;
    }

    @Override
    public void remove(K key) {
        rootNode = remove(key, rootNode);
    }
    private TreeNode remove(K key, TreeNode node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return remove(key, node.left);
        }
        if (key.compareTo(node.key) > 0) {
            return remove(key, node.right);
        }
        if (key.equals(node.key)) {
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                return left;
            }
            TreeNode rightSmall = getSmall(node.right);
            rightSmall.left = node.left;
            rightSmall.right = removeSmall(node.right);
            node.left = node.right = null;
            return rightSmall;
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        if (contains(key, rootNode) != null) {
            return true;
        }
        return false;
    }
    private TreeNode contains(K key, TreeNode node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
             return contains(key, node.left);
        }
        if (key.compareTo(node.key) > 0) {
            return contains(key, node.right);
        }
        if (key.equals(node.key)) {
            return node;
        }
        return node;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
