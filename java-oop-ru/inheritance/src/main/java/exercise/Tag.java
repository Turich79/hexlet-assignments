package exercise;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private String nameTag;
    private Map<String,String> map;

    public Tag(String nameTag, Map<String, String> map) {
        this.nameTag = nameTag;
        this.map = new LinkedHashMap<>(map);
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String getNameTag() {
        return nameTag;
    }

    public abstract String toString();
}
// END
