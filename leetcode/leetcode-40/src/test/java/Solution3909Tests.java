import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3909Tests {
    private final Solution3909 solution3909 = new Solution3909();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3909.compareBitonicSums(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 5, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution3909.compareBitonicSums(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 4, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution3909.compareBitonicSums(nums));
    }
}