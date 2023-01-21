package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> storage = new HashMap<>();

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.storage.putAll(map);
    }

    @Override
    public void set(String key, String value) {
        String dataPath = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(dataPath);
        map.put(key, value);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        String dataPath = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(dataPath);
        map.remove(key);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        String dataPath = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(dataPath);
        return map.getOrDefault(key, defaultValue);

    }

    @Override
    public Map<String, String> toMap() {
        String dataPath = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(dataPath);
        return new HashMap<>(map);
    }
}
// END
