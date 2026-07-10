import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3981Tests {
    private final Solution3981 solution3981 = new Solution3981();

    @Test
    public void example1() {
        String word1 = "abc";
        String word2 = "bac";
        String target = "abc";
        int expected = 5;
        Assertions.assertEquals(expected, solution3981.interleaveCharacters(word1, word2, target));
    }

    @Test
    public void example2() {
        String word1 = "cd";
        String word2 = "cd";
        String target = "ccd";
        int expected = 4;
        Assertions.assertEquals(expected, solution3981.interleaveCharacters(word1, word2, target));
    }

    @Test
    public void example3() {
        String word1 = "xy";
        String word2 = "xy";
        String target = "xyxy";
        int expected = 2;
        Assertions.assertEquals(expected, solution3981.interleaveCharacters(word1, word2, target));
    }

    @Test
    public void example4() {
        String word1 = "ab";
        String word2 = "cde";
        String target = "ace";
        int expected = 1;
        Assertions.assertEquals(expected, solution3981.interleaveCharacters(word1, word2, target));
    }
}