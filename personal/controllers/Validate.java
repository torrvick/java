package personal.controllers;

import personal.model.User;
import java.util.regex.Pattern;


public class Validate {
    public void validate(User user) {
        if (!pattern.matcher(user.getFirstName()).find()) {
            throw new RuntimeException("Имя пользователя не может быть пустым");

        }
        if (!pattern.matcher(user.getLastName()).find()) {
            throw new RuntimeException("Фамилия пользователя не может быть пустой");
        }
        if (!patternDigit.matcher(user.getPhone()).find()) {
            throw new RuntimeException("Номер телефона пользователя не может быть пустым");
        }
    }
    final String REGEX = "^\\S+$";
    final String REDIGIT = "^\\d+$";
    final Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
    final Pattern patternDigit = Pattern.compile((REDIGIT));

}