import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3541Tests {
    private final Solution3541 solution3541 = new Solution3541();

    @Test
    public void example1() {
        String s = "successes";
        int expected = 6;
        Assertions.assertEquals(expected, solution3541.maxFreqSum(s));
    }

    @Test
    public void example2() {
        String s = "aeiaeia";
        int expected = 3;
        Assertions.assertEquals(expected, solution3541.maxFreqSum(s));
    }
}