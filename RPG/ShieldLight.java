public class ShieldLight implements Shield{
    private String name;
    public ShieldLight() {
        this.name = "Легкий щит";
    }

    @Override
    public int reduceDamage() {
        return 5;
    }

    @Override
    public String toString() {
        return String.format("%s. Защита: %s", this.name, this.reduceDamage());
    }
}
