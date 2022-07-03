import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1062Tests {
    private final Solution1062 solution1062 = new Solution1062();

    @Test
    public void example1() {
        String s = "abcd";
        int expected = 0;
        Assertions.assertEquals(expected, solution1062.longestRepeatingSubstring(s));
    }

    @Test
    public void example2() {
        String s = "abbaba";
        int expected = 2;
        Assertions.assertEquals(expected, solution1062.longestRepeatingSubstring(s));
    }

    @Test
    public void example3() {
        String s = "aabcaabdaab";
        int expected = 3;
        Assertions.assertEquals(expected, solution1062.longestRepeatingSubstring(s));
    }

    @Test
    public void example4() {
        String s = "aaaaa";
        int expected = 4;
        Assertions.assertEquals(expected, solution1062.longestRepeatingSubstring(s));
    }
}
