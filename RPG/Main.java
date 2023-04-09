public class Main {
    public static void main(String[] args) {
        Team<Archer> archers = new Team<>();
        // Team<Thief> thiefTeam = new Team<>();
        archers.addPers(new Archer("Робин", 100, new Bow(20), new ShieldLight()))
                .addPers(new Archer("Гуд", 100, new Bow(15), new ShieldLight()));
        // thiefTeam.addPers(new Thief("Джек", 150, new Knife()))
        //         .addPers(new Thief("Потрошитель", 150, new Knife()));
        System.out.println(archers);
        System.out.println();
        // System.out.println(thiefTeam);

        Archer robin = new Archer("Робин", 100, new Bow(20), new ShieldLight());
        Archer gud = new Archer("Гуд", 100, new Bow(15), new ShieldLight());

        Thief a = new Thief("Джек", 15, new Knife(), new ShieldLight());
        Thief b = new Thief("Вася", 15, new Knife(), new ShieldLight());
        // Battle fight = new Battle(robin, gud);
        Battle fight = new Battle(a, b);
        fight.run();
    }
}