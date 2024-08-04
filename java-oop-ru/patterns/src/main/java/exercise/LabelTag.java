package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String textTag;
    private TagInterface inputTag;

    @Override
    public String render() {
//        return "<label>Press Submit<input type=\"" + type + "\" value=\"" + value + "\"></label>";
        return "<label>" + textTag + inputTag.render() + "</label>";
    }

    public LabelTag(String textTag, TagInterface inputTag) {
        this.inputTag = inputTag;
        this.textTag = textTag;
    }
}
// END
