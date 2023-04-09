public class Battle {
    Warrior attacker;
    Warrior defender;

    public Battle(Warrior attacker, Warrior defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Warrior run() {
        while (true) {
            int attack = attacker.harm();
            defender.reduceHp(attack);
            System.out.printf("Воин %s наносит %d очков урона \nУ воина %s осталось %d hp\n", attacker.getName(), attack, defender.getName(), defender.getHp());
            if (!defender.isAlive()){
                System.out.printf("\nВоин %s погиб\n\n", defender.getName());
                System.out.printf("Победитель: \n%s\n", attacker);
                return attacker;
            }
            int response = defender.harm();
            attacker.reduceHp(response);
            System.out.printf("Воин %s дал в ответку на %d очков урона \nУ воина %s осталось %d hp\n", defender.getName(), response, attacker.getName(), attacker.getHp());
            if (!attacker.isAlive()){
                System.out.printf("\nВоин %s погиб\n\n", attacker.getName());
                System.out.printf("Победитель: \n%s\n", defender);
                return defender;
            }
        }
    }
}
