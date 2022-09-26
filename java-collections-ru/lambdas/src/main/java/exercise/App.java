package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .flatMap(x -> Stream.of(x, x)
                .map(y -> Stream.of(y)
                .flatMap(element -> Stream.of(element, element))
                .toArray(String[]::new)))
                .toArray(String[][]::new);

    }
}
// END
