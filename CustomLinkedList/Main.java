package CustomLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
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
