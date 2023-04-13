package personal.model;

public class UserMapper {
    private String separator;
    private String linesSeparator;

    public UserMapper(String fformat) {
        switch (fformat) {
            case "old":
                separator = ",";
                linesSeparator = "";
                break;
            case "new":
                separator = ";";
                linesSeparator = "\n";
                break;
        }
    }
    public String map(User user) {
        return String.format("%s%s%s%s%s%s%s%s", 
                                    user.getId(), 
                                    separator, 
                                    user.getFirstName(), 
                                    separator, 
                                    user.getLastName(), 
                                    separator, 
                                    user.getPhone(), 
                                    linesSeparator);
    }

    public User map(String line) {
        String[] lines = line.split(separator);
        return new User(lines[0], lines[1], lines[2], lines[3]);
    }
}
