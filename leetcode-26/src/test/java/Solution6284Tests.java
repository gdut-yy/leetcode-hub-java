import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6284Tests {
    private final Solution6284 solution6284 = new Solution6284();

    @Test
    public void example1() {
        String word1 = "ac";
        String word2 = "b";
        Assertions.assertFalse(solution6284.isItPossible(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "abcc";
        String word2 = "aab";
        Assertions.assertTrue(solution6284.isItPossible(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "abcde";
        String word2 = "fghij";
        Assertions.assertTrue(solution6284.isItPossible(word1, word2));
    }
}
