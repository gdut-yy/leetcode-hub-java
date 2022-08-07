import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6142Tests {
    private final Solution6142 solution6142 = new Solution6142();

    @Test
    public void example1() {
        int[] nums = {4, 1, 3, 3};
        long expected = 5;
        Assertions.assertEquals(expected, solution6142.countBadPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        long expected = 0;
        Assertions.assertEquals(expected, solution6142.countBadPairs(nums));
    }
}
