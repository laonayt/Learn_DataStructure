package BasicStructure.SetAndMap;


public class LinkedMap<K,V> implements Map<K,V> {

    private class LinkedNode {
        K key;
        V value;
        LinkedNode next;
        LinkedNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("{%s : %s}",key.toString(),value.toString());
        }
    }

    private LinkedNode dummyHead = new LinkedNode(null, null);

    @Override
    public void set(K key, V val) {
        LinkedNode linkedNode = new LinkedNode(key, val);
        linkedNode.next = dummyHead.next;
        dummyHead.next = linkedNode;
    }

    @Override
    public V get(K key) {
        for (LinkedNode node = dummyHead.next; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        LinkedNode node = dummyHead;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        //这种写法的问题？
//        for (LinkedNode node = dummyHead; node.next != null; node = node.next) {
//            if (node.next.key.equals(key)) {
//                node.next = null;
////                LinkedNode d = node.next.next;
////                node.next = null;
////                node.next = d;
////                node.next = node.next.next;
//            }
//        }
    }

    @Override
    public boolean contains(K key) {
        for (LinkedNode node = dummyHead; node.next != null; node = node.next) {
            if (key.equals(node.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return dummyHead.next == null;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (LinkedNode node = dummyHead; node.next != null; node = node.next) {
            size++;
        }
        return size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList: size = %d \n", getSize()));

        for(LinkedNode node = dummyHead.next ; node != null ; node = node.next)
            res.append(node + "->");
        res.append("NULL");

        return res.toString();
    }
}
