import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6462Tests {
    private final Solution6462 solution6462 = new Solution6462();

    @Test
    public void example1() {
        String s = "aaabc";
        int expected = 3;
        Assertions.assertEquals(expected, solution6462.minimizedStringLength(s));
    }

    @Test
    public void example2() {
        String s = "cbbd";
        int expected = 3;
        Assertions.assertEquals(expected, solution6462.minimizedStringLength(s));
    }

    @Test
    public void example3() {
        String s = "dddaaa";
        int expected = 2;
        Assertions.assertEquals(expected, solution6462.minimizedStringLength(s));
    }
}