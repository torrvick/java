public class Main {
    public static void main(String[] args) {
        // Team<Archer> archers = new Team<>();
        // archers.addPers(new Archer("Робин", 100, new Bow(20), new ShieldLight()))
        //         .addPers(new Archer("Гуд", 100, new Bow(15), new ShieldNone()));
        // System.out.println(archers);
        // System.out.println();

        Knight knight1 = new Knight("Ланселот", 150, new Sword(), new ShieldLight());
        Knight knight2 = new Knight("Король Артур", 150, new Sword(), new ShieldHeavy());
        Team<Knight> knights = new Team<>();
        knights.addPers(knight1).addPers(knight2);
        System.out.println(knights);

        Battle fight = new Battle(knight1, knight2);
        fight.fight();
    }
}