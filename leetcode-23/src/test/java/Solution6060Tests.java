import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6060Tests {
    private final Solution6060 solution6060 = new Solution6060();

    @Test
    public void example1() {
        int[] nums = {-4, -2, 1, 4, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution6060.findClosestNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, -1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution6060.findClosestNumber(nums));
    }
}
