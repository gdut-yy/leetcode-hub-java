import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution487Tests {
    private final Solution487 solution487 = new Solution487();

    @Test
    public void example1() {
        int[] nums = {1, 0, 1, 1, 0};
        int expected = 4;
        Assertions.assertEquals(expected, solution487.findMaxConsecutiveOnes(nums));
    }
}
