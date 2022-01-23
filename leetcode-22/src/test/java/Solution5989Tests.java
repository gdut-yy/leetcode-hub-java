import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5989Tests {
    private final Solution5989 solution5989 = new Solution5989();

    @Test
    public void example1() {
        int[] nums = {11, 7, 2, 15};
        int expected = 2;
        Assertions.assertEquals(expected, solution5989.countElements(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-3, 3, 3, 90};
        int expected = 2;
        Assertions.assertEquals(expected, solution5989.countElements(nums));
    }
}
