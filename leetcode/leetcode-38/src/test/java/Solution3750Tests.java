import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3750Tests {
    private final Solution3750 solution3750 = new Solution3750();

    @Test
    public void example1() {
        int n = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution3750.minimumFlips(n));
        Assertions.assertEquals(expected, solution3750.minimumFlips2(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution3750.minimumFlips(n));
        Assertions.assertEquals(expected, solution3750.minimumFlips2(n));
    }
}