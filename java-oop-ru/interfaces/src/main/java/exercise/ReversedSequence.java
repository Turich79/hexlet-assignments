package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final String text;

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int i) {
        return text.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return text.subSequence(i, i1);
    }

    @Override
    public String toString() {
        return text;
    }

    public ReversedSequence(String text) {
        this.text = new StringBuilder(text).reverse().toString();
    }
}
// END
