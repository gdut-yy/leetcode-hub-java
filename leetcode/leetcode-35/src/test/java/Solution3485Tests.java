import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3485Tests {
    private final Solution3485 solution3485 = new Solution3485();

    @Test
    public void example1() {
        String[] words = {"jump", "run", "run", "jump", "run"};
        int k = 2;
        int[] expected = {3, 4, 4, 3, 4};
        Assertions.assertArrayEquals(expected, solution3485.longestCommonPrefix(words, k));
    }

    @Test
    public void example2() {
        String[] words = {"dog", "racer", "car"};
        int k = 2;
        int[] expected = {0, 0, 0};
        Assertions.assertArrayEquals(expected, solution3485.longestCommonPrefix(words, k));
    }
}