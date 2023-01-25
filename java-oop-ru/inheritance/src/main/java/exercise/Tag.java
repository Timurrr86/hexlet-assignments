package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class Tag {
    private final String name;
    protected Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String mapToString() {
        if (attributes.isEmpty()) {
            return "";
        } else {
            return attributes.keySet().stream()
                    .map(key -> " " + key + "=\"" + attributes.get(key) + "\"")
                    .collect(Collectors.joining(""));
        }
    }
}
// END
