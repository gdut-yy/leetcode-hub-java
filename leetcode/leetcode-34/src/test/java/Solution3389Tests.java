import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3389Tests {
    private final Solution3389 solution3389 = new Solution3389();

    @Test
    public void example1() {
        String s = "acab";
        int expected = 1;
        Assertions.assertEquals(expected, solution3389.makeStringGood(s));
    }

    @Test
    public void example2() {
        String s = "wddw";
        int expected = 0;
        Assertions.assertEquals(expected, solution3389.makeStringGood(s));
    }

    @Test
    public void example3() {
        String s = "aaabc";
        int expected = 2;
        Assertions.assertEquals(expected, solution3389.makeStringGood(s));
    }
}