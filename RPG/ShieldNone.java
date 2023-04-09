public class ShieldNone implements Shield{
    private String name;
    public ShieldNone() {
        this.name = "Отсутствует";
    }

    @Override
    public int reduceDamage() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s. Защита: %s", this.name, this.reduceDamage());
    }
}
