public class Battle {
    Warrior attacker;
    Warrior defender;

    public Battle(Warrior attacker, Warrior defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public void fight() {
        System.out.println("Да будет битва!\n");
        run(attacker, defender);
    }

    private Warrior run(Warrior attacker, Warrior defender) {
        if (!attacker.isAlive()) {
            System.out.printf("\nВоин %s погиб\n\n", attacker.getName());
            System.out.printf("Победитель: \n%s\n", defender);
            return defender;
        }
        if (!defender.isAlive()) {
            System.out.printf("\nВоин %s погиб\n\n", defender.getName());
            System.out.printf("Победитель: \n%s\n", attacker);
            return attacker;
        }
        
        while (true) {
            int attack = attacker.harm();
            int defence = defender.defence();
            int totalHarm = attack - defence;
            if (totalHarm < 0 ) totalHarm = 0;
            defender.reduceHp(totalHarm);
            System.out.printf("Воин %s наносит %s очков атаки \n" + 
                                "Щит воина %s отражает %s очков\n" + 
                                "Воин %s получает %s очков урона\n" + 
                                "У воина %s осталось %s hp\n\n", 
                                attacker.getName(), attack, defender.getName(), defence, defender.getName(), totalHarm, defender.getName(), defender.getHp());
            Warrior temp = attacker;
            attacker = defender;
            defender = temp;
            return run(attacker, defender);
        }
    }
}
