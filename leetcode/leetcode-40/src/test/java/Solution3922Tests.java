import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3922Tests {
    private final Solution3922 solution3922 = new Solution3922();

    @Test
    public void example1() {
        String s = "1010";
        int expected = 1;
        Assertions.assertEquals(expected, solution3922.minFlips(s));
    }

    @Test
    public void example2() {
        String s = "0110";
        int expected = 1;
        Assertions.assertEquals(expected, solution3922.minFlips(s));
    }

    @Test
    public void example3() {
        String s = "1000";
        int expected = 0;
        Assertions.assertEquals(expected, solution3922.minFlips(s));
    }
}