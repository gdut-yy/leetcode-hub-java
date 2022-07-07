import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution244Tests {
    @Test
    public void example1() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        Solution244.WordDistance wordDistance = new Solution244.WordDistance(wordsDict);
        // 返回 3
        Assertions.assertEquals(3, wordDistance.shortest("coding", "practice"));
        // 返回 1
        Assertions.assertEquals(1, wordDistance.shortest("makes", "coding"));
    }
}
