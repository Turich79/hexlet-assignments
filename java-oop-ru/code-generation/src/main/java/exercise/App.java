package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            Files.writeString(path, car.serialize(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static Car extract(Path path) {
        Car car = new Car();
        try {
            car = car.deserialize(Files.readString(path));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return car;
    }
}
