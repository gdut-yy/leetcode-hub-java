import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3499Tests {
    private final Solution3499 solution3499 = new Solution3499();

    @Test
    public void example1() {
        String s = "01";
        int expected = 1;
        Assertions.assertEquals(expected, solution3499.maxActiveSectionsAfterTrade(s));
    }

    @Test
    public void example2() {
        String s = "0100";
        int expected = 4;
        Assertions.assertEquals(expected, solution3499.maxActiveSectionsAfterTrade(s));
    }

    @Test
    public void example3() {
        String s = "1000100";
        int expected = 7;
        Assertions.assertEquals(expected, solution3499.maxActiveSectionsAfterTrade(s));
    }

    @Test
    public void example4() {
        String s = "01010";
        int expected = 4;
        Assertions.assertEquals(expected, solution3499.maxActiveSectionsAfterTrade(s));
    }
}