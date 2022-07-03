import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1044Tests {
    private final Solution1044 solution1044 = new Solution1044();

    @Test
    public void example1() {
        String s = "banana";
        String expected = "ana";
        Assertions.assertEquals(expected, solution1044.longestDupSubstring(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String expected = "";
        Assertions.assertEquals(expected, solution1044.longestDupSubstring(s));
    }
}
