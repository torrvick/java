package personal.model;

public class UserMapper {
    private final String SEPARATOR = ";";
    private final String LINES_SEPARATOR = "\n";

    public String map(User user) {
        return String.format("%s%s%s%s%s%s%s%s", 
                                    user.getId(), 
                                    SEPARATOR, 
                                    user.getFirstName(), 
                                    SEPARATOR, 
                                    user.getLastName(), 
                                    SEPARATOR, 
                                    user.getPhone(), 
                                    LINES_SEPARATOR);
    }

    public User map(String line) {
        String[] lines = line.split(SEPARATOR);
        return new User(lines[0], lines[1], lines[2], lines[3]);
    }
}
