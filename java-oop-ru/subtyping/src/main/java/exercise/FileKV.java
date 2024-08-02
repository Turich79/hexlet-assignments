package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private String filePath;
    private HashMap<String,String> storage;

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(this.storage));
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(this.storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        storage = new HashMap<>(Utils.deserialize(Utils.readFile(filePath)));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        storage = new HashMap<>(Utils.deserialize(Utils.readFile(filePath)));
        return new HashMap<>(storage);
    }

    public FileKV(String filePath, Map<String, String> storage) {
        this.filePath = filePath;
        this.storage = new HashMap<>(storage);
        Utils.writeFile(filePath, Utils.serialize(this.storage));
    }
}
// END
