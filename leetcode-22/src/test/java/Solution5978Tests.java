import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5978Tests {
    private final Solution5978 solution5978 = new Solution5978();

    @Test
    public void example1() {
        String[] startWords = {"ant", "act", "tack"};
        String[] targetWords = {"tack", "act", "acti"};
        int expected = 2;
        Assertions.assertEquals(expected, solution5978.wordCount(startWords, targetWords));
    }

    @Test
    public void example2() {
        String[] startWords = {"ab", "a"};
        String[] targetWords = {"abc", "abcd"};
        int expected = 1;
        Assertions.assertEquals(expected, solution5978.wordCount(startWords, targetWords));
    }
}
