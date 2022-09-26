package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String data) {
        String[] arrayFromFile = data.split("\n");
        return Stream.of(arrayFromFile)
                .filter(str -> str.startsWith("environment"))
                .map(str -> str.replaceAll("environment=", ""))
                .map(str -> str.replaceAll("\"", ""))
                .map(str -> str.split(","))
                .flatmap(Arrays::stream)
                .filter(element -> element.startsWith("X_FORWARDED"))
                .map(element -> element.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END



