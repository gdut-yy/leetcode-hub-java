import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3045Tests {
    private final Solution3045 solution3045 = new Solution3045();

    @Test
    public void example1() {
        String[] words = {"a", "aba", "ababa", "aa"};
        long expected = 4;
        Assertions.assertEquals(expected, solution3045.countPrefixSuffixPairs(words));
    }

    @Test
    public void example2() {
        String[] words = {"pa", "papa", "ma", "mama"};
        long expected = 2;
        Assertions.assertEquals(expected, solution3045.countPrefixSuffixPairs(words));
    }

    @Test
    public void example3() {
        String[] words = {"abab", "ab"};
        long expected = 0;
        Assertions.assertEquals(expected, solution3045.countPrefixSuffixPairs(words));
    }
}