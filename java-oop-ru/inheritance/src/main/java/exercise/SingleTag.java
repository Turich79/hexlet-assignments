package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String nameTag, Map<String, String> map) {
        super(nameTag, map);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<" + super.getNameTag());
        super.getMap().forEach((key, value) -> {
            result.append(" " + key + "=");
            result.append("\"" + value + "\"");
        });
        result.append(">");
        return result.toString();
    }
}
// END
