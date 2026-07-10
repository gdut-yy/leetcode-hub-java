import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3980Tests {
    private final Solution3980 solution3980 = new Solution3980();

    @Test
    public void example1() {
        String s1 = "11";
        String s2 = "00";
        int expected = 1;
        Assertions.assertEquals(expected, solution3980.minOperations(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "01";
        String s2 = "10";
        int expected = 3;
        Assertions.assertEquals(expected, solution3980.minOperations(s1, s2));
    }

    @Test
    public void example3() {
        String s1 = "1";
        String s2 = "0";
        int expected = -1;
        Assertions.assertEquals(expected, solution3980.minOperations(s1, s2));
    }
}