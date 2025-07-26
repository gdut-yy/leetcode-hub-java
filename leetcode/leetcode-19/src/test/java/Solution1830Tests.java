import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1830Tests {
    private final Solution1830 solution1830 = new Solution1830();

    @Test
    public void example1() {
        String s = "cba";
        int expected = 5;
        Assertions.assertEquals(expected, solution1830.makeStringSorted(s));
    }

    @Test
    public void example2() {
        String s = "aabaa";
        int expected = 2;
        Assertions.assertEquals(expected, solution1830.makeStringSorted(s));
    }

    @Test
    public void example3() {
        String s = "cdbea";
        int expected = 63;
        Assertions.assertEquals(expected, solution1830.makeStringSorted(s));
    }

    @Test
    public void example4() {
        String s = "leetcodeleetcodeleetcode";
        int expected = 982157772;
        Assertions.assertEquals(expected, solution1830.makeStringSorted(s));
    }
}