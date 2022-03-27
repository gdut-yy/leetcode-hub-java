import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5236Tests {
    private final Solution5236 solution5236 = new Solution5236();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 3, 5};
        int expected = 1;
        Assertions.assertEquals(expected, solution5236.minDeletion(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 2, 3, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution5236.minDeletion(nums));
    }
}
