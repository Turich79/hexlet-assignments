package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private  HashMap<String, String> storage;

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
//        return storage;
        return new HashMap<>(storage);
    }

    public InMemoryKV(Map<String, String> storage) {
        this.storage = new HashMap<>(storage);
    }
}
// END
