package CustomLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomList<Integer> list = new CustomList<>();
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(3);
        // list.print();
        for (int value : list) {
            System.out.println(value);
        }
    }
}
