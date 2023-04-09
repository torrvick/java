public class Bow extends Throwing{
    private String name;
    public Bow(int range) {
        super(range);
        this.name = "Лук";
    }

    @Override
    public int damage() {
        return 20;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(name)
                .append(String.format("%s", super.toString()));
        return res.toString();
    }
}
