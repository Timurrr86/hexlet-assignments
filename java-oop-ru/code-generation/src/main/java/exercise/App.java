package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        String data = car.serialize();
        Files.writeString(path, data, StandardOpenOption.CREATE);
    }

    public static Car extract(Path path) throws IOException {
        String jsonRepresentation = Files.readString(path);
        return Car.unserialize(jsonRepresentation);
    }
}

// END
