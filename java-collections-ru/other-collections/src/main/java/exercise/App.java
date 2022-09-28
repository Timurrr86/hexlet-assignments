package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> treeSet = new TreeSet<>(Comparator.comparing(k -> k));
        treeSet.addAll(map1.keySet());
        treeSet.addAll(map2.keySet());
        Map<String, String> difference = new LinkedHashMap<>();
        treeSet.forEach(x -> {
           if (!map1.containsKey(x)) {
               difference.put(x, "added");
           } else if (!map2.containsKey(x)) {
               difference.put(x, "deleted");
               } else if (map1.get(x) != map2.get(x)) {
                difference.put(x, "changed");
           } else {
                difference.put(x, "unchanged");
            }
        });
        return difference;
    }
}
//END
