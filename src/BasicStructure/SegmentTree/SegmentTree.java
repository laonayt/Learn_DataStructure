package BasicStructure.SegmentTree;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];

//        this.data = arr;

        this.merger = merger;
        this.tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, arr.length-1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        int mid = (r+l) / 2;
        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);

        tree[treeIndex] = this.merger.merge(tree[leftChild], tree[rightChild]);
    }

    private int leftChild(int index) {
        return index*2 +1;
    }
    private int rightChild(int index) {
        return index*2 + 2;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
