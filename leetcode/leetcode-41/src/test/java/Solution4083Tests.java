import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4083Tests {
    private final Solution4083 solution4083 = new Solution4083();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution4083.minDeletions(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 9, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution4083.minDeletions(nums));
    }
}
