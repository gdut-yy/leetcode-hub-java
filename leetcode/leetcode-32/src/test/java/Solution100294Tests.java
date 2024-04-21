import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100294Tests {
    private final Solution100294 solution100294 = new Solution100294();

    @Test
    public void example1() {
        String word = "aaAbcBC";
        int expected = 3;
        Assertions.assertEquals(expected, solution100294.numberOfSpecialChars(word));
    }

    @Test
    public void example2() {
        String word = "abc";
        int expected = 0;
        Assertions.assertEquals(expected, solution100294.numberOfSpecialChars(word));
    }

    @Test
    public void example3() {
        String word = "abBCab";
        int expected = 1;
        Assertions.assertEquals(expected, solution100294.numberOfSpecialChars(word));
    }
}