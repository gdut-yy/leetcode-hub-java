import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6105Tests {
    private final Solution6105 solution6105 = new Solution6105();

    @Test
    public void example1() {
        int[] nums = {3, 2, 4, 6};
        int expected = 7;
        Assertions.assertEquals(expected, solution6105.maximumXOR(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 9, 2};
        int expected = 11;
        Assertions.assertEquals(expected, solution6105.maximumXOR(nums));
    }
}
