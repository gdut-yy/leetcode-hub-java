import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3628Tests {
    private final Solution3628 solution3628 = new Solution3628();

    @Test
    public void example1() {
        String s = "LMCT";
        long expected = 2;
        Assertions.assertEquals(expected, solution3628.numOfSubsequences(s));
    }

    @Test
    public void example2() {
        String s = "LCCT";
        long expected = 4;
        Assertions.assertEquals(expected, solution3628.numOfSubsequences(s));
    }

    @Test
    public void example3() {
        String s = "L";
        long expected = 0;
        Assertions.assertEquals(expected, solution3628.numOfSubsequences(s));
    }
}