package BasicStructure.SetAndMap;

public class Test {
    public static void main(String[] args) {

//        testSet();
        testMap();
    }

    private static void testSet() {

    }

    private static void testMap() {
//        LinkedMap linkedMap = new LinkedMap();
//        linkedMap.set("name", "jack");
//        linkedMap.set("age", 18);
////        System.out.print(linkedMap.get("name"));
//        linkedMap.remove("name");
//        System.out.print(linkedMap);

        BSTMap bstMap = new BSTMap();

//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for (int e : nums) {
//            bstMap.set(e, "haha");
//        }
//        bstMap.preOrder();
//        System.out.print("\n");
//        bstMap.removeSmall();
//        bstMap.preOrder();

        bstMap.set("name", "jack");
        bstMap.set("age", 18);
        bstMap.preOrder();
//        System.out.print(bstMap.get("age"));
//        System.out.print(bstMap.contains("name"));

        System.out.print("\n");
        bstMap.remove("name");
        bstMap.preOrder();
    }
}
