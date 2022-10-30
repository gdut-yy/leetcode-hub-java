import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6220Tests {
    private final Solution6220 solution6220 = new Solution6220();

    @Test
    public void example1() {
        int[] nums = {1, 3, 6, 10, 12, 15};
        int expected = 9;
        Assertions.assertEquals(expected, solution6220.averageValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4, 7, 10};
        int expected = 0;
        Assertions.assertEquals(expected, solution6220.averageValue(nums));
    }
}
