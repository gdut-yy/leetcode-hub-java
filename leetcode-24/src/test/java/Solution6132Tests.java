import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6132Tests {
    private final Solution6132 solution6132 = new Solution6132();

    @Test
    public void example1() {
        int[] nums = {1, 5, 0, 3, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution6132.minimumOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution6132.minimumOperations(nums));
    }
}
