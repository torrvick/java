public class Sword implements Weapon{
    @Override
    public int damage() {
        return 50;
    }

    @Override
    public String toString() {
        return String.format("Меч (макс.урон %d)", this.damage());
    }
}