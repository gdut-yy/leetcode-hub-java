import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution245Tests {
    private final Solution245 solution245 = new Solution245();

    @Test
    public void example1() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int expected = 1;
        Assertions.assertEquals(expected, solution245.shortestWordDistance(wordsDict, word1, word2));
    }

    @Test
    public void example2() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        int expected = 3;
        Assertions.assertEquals(expected, solution245.shortestWordDistance(wordsDict, word1, word2));
    }
}
