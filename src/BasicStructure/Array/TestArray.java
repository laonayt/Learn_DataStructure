package BasicStructure.Array;

public class TestArray {

    public static void main(String[] args) {

        testArray();
    }

    public static void testArray() {
        //基本数据类型
        WEArray<Integer> array = new WEArray(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.insert(100,1);
        array.addFirst(-1);
        array.removeFirst();
        array.removeLast();
        System.out.print(array);

        //对象类型
        WEArray<Student> studentArray = new WEArray<>(20);
        for (int i = 0; i < 10; i++) {
            Student student = new Student("we", i);
            studentArray.addLast(student);
        }
        studentArray.removeFirst();
        studentArray.removeLast();
        System.out.print(studentArray);

    }

}
