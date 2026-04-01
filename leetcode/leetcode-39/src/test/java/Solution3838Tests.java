import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3838Tests {
    private final Solution3838 solution3838 = new Solution3838();

    @Test
    public void example1() {
        String[] words = {"abcd", "def", "xyz"};
        int[] weights = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        String expected = "rij";
        Assertions.assertEquals(expected, solution3838.mapWordWeights(words, weights));
    }

    @Test
    public void example2() {
        String[] words = {"a", "b", "c"};
        int[] weights = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        String expected = "yyy";
        Assertions.assertEquals(expected, solution3838.mapWordWeights(words, weights));
    }

    @Test
    public void example3() {
        String[] words = {"abcd"};
        int[] weights = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
        String expected = "g";
        Assertions.assertEquals(expected, solution3838.mapWordWeights(words, weights));
    }
}