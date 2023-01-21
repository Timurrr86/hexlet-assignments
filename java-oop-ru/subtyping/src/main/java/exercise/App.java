package exercise;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> tempMap = storage.toMap();
        for(Map.Entry<String, String> entries : tempMap.entrySet()) {
            storage.unset(entries.getKey());
        }
        for(Map.Entry<String, String> entries : tempMap.entrySet()) {
            storage.set(entries.getValue(), entries.getKey());
        }
    }
}
// END
