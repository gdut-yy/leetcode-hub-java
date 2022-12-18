import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6265Tests {
    private final Solution6265 solution6265 = new Solution6265();

    @Test
    public void example1() {
        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        int expected = 2;
        Assertions.assertEquals(expected, solution6265.similarPairs(words));
    }

    @Test
    public void example2() {
        String[] words = {"aabb", "ab", "ba"};
        int expected = 3;
        Assertions.assertEquals(expected, solution6265.similarPairs(words));
    }

    @Test
    public void example3() {
        String[] words = {"nba", "cba", "dba"};
        int expected = 0;
        Assertions.assertEquals(expected, solution6265.similarPairs(words));
    }
}
