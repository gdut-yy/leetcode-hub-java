import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6893Tests {
    private final Solution6893 solution6893 = new Solution6893();

    @Test
    public void example1() {
        int[] nums = {2, 3, 6};
        int expected = 2;
        Assertions.assertEquals(expected, solution6893.specialPerm(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution6893.specialPerm(nums));
    }
}