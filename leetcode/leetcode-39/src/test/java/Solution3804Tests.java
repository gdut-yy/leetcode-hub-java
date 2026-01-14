import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3804Tests {
    private final Solution3804 solution3804 = new Solution3804();

    @Test
    public void example1() {
        int[] nums = {-1, 1, 0};
        int expected = 5;
        Assertions.assertEquals(expected, solution3804.centeredSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, -3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3804.centeredSubarrays(nums));
    }
}