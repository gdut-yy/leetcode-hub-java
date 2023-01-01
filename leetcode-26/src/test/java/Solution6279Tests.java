import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6279Tests {
    private final Solution6279 solution6279 = new Solution6279();

    @Test
    public void example1() {
        int[] nums = {2, 4, 3, 7, 10, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solution6279.distinctPrimeFactors(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 8, 16};
        int expected = 1;
        Assertions.assertEquals(expected, solution6279.distinctPrimeFactors(nums));
    }
}
