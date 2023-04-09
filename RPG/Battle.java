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
            int defence = defender.defence();
            int totalHarm = attack - defence;
            if (totalHarm < 0 ) totalHarm = 0;
            defender.reduceHp(totalHarm);
            System.out.printf("Воин %s наносит %s очков атаки \n" + 
                                "Щит отражает %s очков\n" + 
                                "Воин %s получает %s очков урона\n" + 
                                "У воина %s осталось %s hp\n\n", 
                                attacker.getName(), attack, defence, defender.getName(), totalHarm, defender.getName(), defender.getHp());
            if (!defender.isAlive()){
                System.out.printf("\nВоин %s погиб\n\n", defender.getName());
                System.out.printf("Победитель: \n%s\n", attacker);
                return attacker;
            }
            attack = defender.harm();
            defence = attacker.defence();
            totalHarm = attack - defence;
            if (totalHarm < 0 ) totalHarm = 0;
            attacker.reduceHp(totalHarm);
            System.out.printf("Воин %s наносит %s очков атаки \n" + 
                                "Щит отражает %s очков\n" + 
                                "Воин %s получает %s очков урона\n" + 
                                "У воина %s осталось %s hp\n\n", 
                                defender.getName(), attack, defence, attacker.getName(), totalHarm, attacker.getName(), attacker.getHp());
            if (!attacker.isAlive()){
                System.out.printf("\nВоин %s погиб\n\n", attacker.getName());
                System.out.printf("Победитель: \n%s\n", defender);
                return defender;
            }
        }
    }
}
