import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6923Tests {
    private final Solution6923 solution6923 = new Solution6923();

    @Test
    public void example1() {
        String s = "1011";
        int expected = 2;
        Assertions.assertEquals(expected, solution6923.minimumBeautifulSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "111";
        int expected = 3;
        Assertions.assertEquals(expected, solution6923.minimumBeautifulSubstrings(s));
    }

    @Test
    public void example3() {
        String s = "0";
        int expected = -1;
        Assertions.assertEquals(expected, solution6923.minimumBeautifulSubstrings(s));
    }
}