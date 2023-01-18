package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        return apartments.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .limit(n)
                .map(Objects::toString)
                .collect(Collectors.toList());
    }
}
// END
