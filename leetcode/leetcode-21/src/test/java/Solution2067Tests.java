import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2067Tests {
    private final Solution2067 solution2067 = new Solution2067();

    @Test
    public void example1() {
        String s = "aaabcbbcc";
        int count = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2067.equalCountSubstrings(s, count));
    }

    @Test
    public void example2() {
        String s = "abcd";
        int count = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2067.equalCountSubstrings(s, count));
    }

    @Test
    public void example3() {
        String s = "a";
        int count = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution2067.equalCountSubstrings(s, count));
    }
}