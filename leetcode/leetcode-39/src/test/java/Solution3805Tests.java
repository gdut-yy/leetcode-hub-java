import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3805Tests {
    private final Solution3805 solution3805 = new Solution3805();

    @Test
    public void example1() {
        String[] words = {"fusion", "layout"};
        long expected = 1;
        Assertions.assertEquals(expected, solution3805.countPairs(words));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "aa", "za", "aa"};
        long expected = 2;
        Assertions.assertEquals(expected, solution3805.countPairs(words));
    }
}