import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3423Tests {
    private final Solution3423 solution3423 = new Solution3423();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution3423.maxAdjacentDistance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-5, -10, -5};
        int expected = 5;
        Assertions.assertEquals(expected, solution3423.maxAdjacentDistance(nums));
    }
}