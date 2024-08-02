package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void main(String[] args) {
//        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value"));
//        storage.set("key2", "value2");
//        System.out.println("1 step:" + storage.toMap());
//        App.swapKeyValue(storage);
//        System.out.println("2 step:" + storage.toMap());
//
//        System.out.println(storage.get("key3", "default"));
//        System.out.println(storage.get("value", ""));
//        System.out.println(storage.get("value2", ""));

        samWork();
    }

    public static void samWork() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.set("key2", "value2");
        // Получение значения по ключу
        System.out.println(storage.get("key", "default")); // "value"
    }

    public static void swapKeyValue(KeyValueStorage storage) {
        var entries = storage.toMap().entrySet();
        for (var entry : entries) {
            String value = entry.getValue();
            String key = entry.getKey();
            storage.unset(key);
            storage.set(value, key);
        }
    }

}
// END
