package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static final List<String> EMAIL_CONSTANTS = List.of("@gmail.com", "@yandex.ru", "@hotmail.com");

    public static int getCountOfFreeEmails(List<String> emails) {
        return (int)emails.stream()
                .filter(email -> EMAIL_CONSTANTS.contains(email.substring(email.lastIndexOf("@"))))
                .count();
    }
}
// END
