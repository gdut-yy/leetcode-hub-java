import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100291Tests {
    private final Solution100291 solution100291 = new Solution100291();

    @Test
    public void example1() {
        String word = "aaAbcBC";
        int expected = 3;
        Assertions.assertEquals(expected, solution100291.numberOfSpecialChars(word));
    }

    @Test
    public void example2() {
        String word = "abc";
        int expected = 0;
        Assertions.assertEquals(expected, solution100291.numberOfSpecialChars(word));
    }

    @Test
    public void example3() {
        String word = "AbBCab";
        int expected = 0;
        Assertions.assertEquals(expected, solution100291.numberOfSpecialChars(word));
    }
}