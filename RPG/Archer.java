public class Archer extends Warrior<Throwing, Shield>{

    public Archer(String name, int hp, Throwing weapon, Shield shield) {
        super(name, hp, weapon, shield);
    }

    public int range(){
        return this.weapon.range;
    }
    
}
