package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public final class PairedTag extends Tag {
    private String body;
    private List<Tag> child;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> child) {
        super(name, attributes);
        this.body = body;
        this.child = child;
    }

    public String childToText() {
        return child.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(""));
    }

    @Override
    public String toString() {
        return "<" + getName() +
                mapToString() +
                ">" +
                body +
                childToText() +
                "</" + getName() + ">";
    }
}
// END
