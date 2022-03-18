import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution243Tests {
    private final Solution243 solution243 = new Solution243();

    @Test
    public void example1() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        int expected = 3;
        Assertions.assertEquals(expected, solution243.shortestDistance(wordsDict, word1, word2));
    }

    @Test
    public void example2() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int expected = 1;
        Assertions.assertEquals(expected, solution243.shortestDistance(wordsDict, word1, word2));
    }
}
