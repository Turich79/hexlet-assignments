package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversedSequenceTest {
    private static CharSequence text;// = "fedcba";

    @BeforeAll
    static void beforeAll() {
        text = new ReversedSequence("abcdef");
    }

    @Test
    void length() {
        int exp = 6;
        assertEquals(exp, text.length());
    }

    @Test
    void charAt() {
        char exp = 'e';
        assertEquals(exp, text.charAt(1));
    }

    @Test
    void subSequence() {
        String exp = "edc";
        assertEquals(exp, text.subSequence(1,4).toString());
    }

    @Test
    void testToString() {
        String exp = "fedcba";
        assertEquals(exp, text.toString());
    }

//    CharSequence text = new ReversedSequence("abcdef");
//text.toString(); // "fedcba"
//text.charAt(1); // 'e'
//text.length(); // 6
//text.subSequence(1, 4).toString(); // "edc"
}