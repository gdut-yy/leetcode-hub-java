import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3757Tests {
    private final Solution3757 solution3757 = new Solution3757();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3757.countEffective(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 4, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solution3757.countEffective(nums));
    }

    @Test
    public void example3() {
        int[] nums = {8, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution3757.countEffective(nums));
    }
}