import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3658Tests {
    private final Solution3658 solution3658 = new Solution3658();

    @Test
    public void example1() {
        int n = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution3658.gcdOfOddEvenSums(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution3658.gcdOfOddEvenSums(n));
    }
}