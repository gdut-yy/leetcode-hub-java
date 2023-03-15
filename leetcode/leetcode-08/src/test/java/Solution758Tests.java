import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution758Tests {
    private final Solution758 solution758 = new Solution758();

    @Test
    public void example1() {
        String[] words = {"ab", "bc"};
        String s = "aabcd";
        String expected = "a<b>abc</b>d";
        Assertions.assertEquals(expected, solution758.boldWords(words, s));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "cb"};
        String s = "aabcd";
        String expected = "a<b>ab</b>cd";
        Assertions.assertEquals(expected, solution758.boldWords(words, s));
    }
}
