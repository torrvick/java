import java.util.Random;

public abstract class Warrior<T extends Weapon, U extends Shield> extends Personage{
protected static Random rnd = new Random();
    protected T weapon;
    protected U shield;
    public Warrior(String name, int hp, T weapon, U shield) {
        super(name, hp);
        this.weapon = weapon;
        this.shield = shield;
    }

    public int harm(){
        int damage;
        damage = rnd.nextInt(weapon.damage()+1);
        return damage;
    }

    public int defence(){
        int defence;
        defence = shield.reduceDamage();
        return defence;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Воин: \t")
                .append(this.getName())
                .append(String.format("\n\tHp: %d", getHp()))
                .append(String.format("\n\tВооружен: %s", this.weapon))
                .append(String.format("\n\tЩит: "+this.shield+"\n"));
        return res.toString();
    }
}
