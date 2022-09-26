package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String data) {
        String[] arrayFromFile = data.split("\n");
        return Arrays.stream(arrayFromFile)
                .filter(str -> str.startsWith("environment"))
                .map(str -> str.replaceAll("environment=", ""))
                .map(str -> str.replaceAll("\"", ""))
                .map(str -> str.split(","))
                .flatMap(Arrays::stream)
                .filter(element -> element.startsWith("X_FORWARDED"))
                .map(element -> element.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
