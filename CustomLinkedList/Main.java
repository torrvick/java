package CustomLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomList<Integer> list = new CustomList<>();
        list.add(0)
            .add(2)
            .add(4)
            .add(6)
            .add(8)
            .add(3);

        for (int value : list) {
            System.out.printf("%s ", value);
        }
    }
}
