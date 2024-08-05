package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String bodyTag;
    List<Tag> children;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<" + super.getNameTag());
        super.getMap().forEach((key, value) -> {
            result.append(" " + key + "=");
            result.append("\"" + value + "\"");
        });
        result.append(">" + bodyTag);

        for (Tag currentTag : children) {
            result.append(currentTag.toString());
        }
        result.append("</" + super.getNameTag() + ">");
        return result.toString();
    }

    public PairedTag(String nameTag, Map<String, String> map, String bodyTag, List<Tag> children) {
        super(nameTag, map);
        this.bodyTag = bodyTag;
        this.children = new ArrayList<>(children);
    }
}
// END
