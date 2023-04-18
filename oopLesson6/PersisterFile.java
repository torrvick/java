public class PersisterFile implements Persister {
    public void save(User user) {
        System.out.println("Save user " + user.getName() + " in file.");
    }
}
