public abstract class Throwing implements Weapon{
    int range;

    public Throwing(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    @Override
    public String toString() {
        return String.format(". Урон: %d. Дальность: %d", damage(), getRange());
    }
}
