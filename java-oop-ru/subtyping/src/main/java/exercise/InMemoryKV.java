package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> storage = new HashMap<>();

    public InMemoryKV(Map<String, String> map) {
        this.storage.putAll(map);
    }

    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    public void set(String key, String value) {
        storage.put(key, value);
    }

    public void unset(String key) {
        storage.remove(key);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
// END
