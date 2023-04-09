public class ShieldHeavy implements Shield{
    private String name;
    public ShieldHeavy() {
        this.name = "Тяжелый щит";
    }

    @Override
    public int reduceDamage() {
        return 15;
    }

    @Override
    public String toString() {
        return String.format("%s. Защита: %s", this.name, this.reduceDamage());
    }
}
