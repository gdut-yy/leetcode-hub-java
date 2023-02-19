import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6361Tests {
    private final Solution6361 solution6361 = new Solution6361();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution6361.minimizeSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 7, 8, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution6361.minimizeSum(nums));
    }
}