import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6237Tests {
    private final Solution6237 solution6237 = new Solution6237();

    @Test
    public void example1() {
        int[] nums = {4, 1, 4, 0, 3, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution6237.distinctAverages(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 100};
        int expected = 1;
        Assertions.assertEquals(expected, solution6237.distinctAverages(nums));
    }
}
