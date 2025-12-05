import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3760Tests {
    private final Solution3760 solution3760 = new Solution3760();

    @Test
    public void example1() {
        String s = "abab";
        int expected = 2;
        Assertions.assertEquals(expected, solution3760.maxDistinct(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        int expected = 4;
        Assertions.assertEquals(expected, solution3760.maxDistinct(s));
    }

    @Test
    public void example3() {
        String s = "aaaa";
        int expected = 1;
        Assertions.assertEquals(expected, solution3760.maxDistinct(s));
    }
}