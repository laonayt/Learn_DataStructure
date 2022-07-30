package BasicStructure.LinkList;

public class TestLinkList {
    public static void main(String[] args) {
        testBasicLink();
    }

    private static void testBasicLink() {
        LinkedList<Integer> linkedList = new LinkedList();

//        linkedList.addFirst(-100);

        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
//        linkedList.addLast(100);
//        linkedList.set(99, 0);
        linkedList.remove(0);
        System.out.print(linkedList + "\n");

//        System.out.print(linkedList.getFirst());
//        System.out.print(linkedList.contains(-100));
//        System.out.print(linkedList.getLast());
    }
}
