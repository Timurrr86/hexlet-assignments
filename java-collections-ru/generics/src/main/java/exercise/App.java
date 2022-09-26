package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> condition) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book : books) {
            int counter = 0;
            for (Map.Entry<String, String> currentBook : book.entrySet()) {
                if (condition.containsValue(currentBook.getValue())) {
                    counter += 1;
                    if (counter == condition.size()) {
                        result.add(book);
                    }
                }
            }
        }
        return result;
    }
}

//END
