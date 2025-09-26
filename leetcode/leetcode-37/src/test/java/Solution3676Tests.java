import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3676Tests {
    private final Solution3676 solution3676 = new Solution3676();

    @Test
    public void example1() {
        int[] nums = {2, 5, 3, 1, 4};
        long expected = 2;
        Assertions.assertEquals(expected, solution3676.bowlSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 1, 2, 3, 4};
        long expected = 3;
        Assertions.assertEquals(expected, solution3676.bowlSubarrays(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1000000000, 999999999, 999999998};
        long expected = 0;
        Assertions.assertEquals(expected, solution3676.bowlSubarrays(nums));
    }
}