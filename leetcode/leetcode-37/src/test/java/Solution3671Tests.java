import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3671Tests {
    private final Solution3671 solution3671 = new Solution3671();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 10;
        Assertions.assertEquals(expected, solution3671.totalBeauty(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 6};
        int expected = 12;
        Assertions.assertEquals(expected, solution3671.totalBeauty(nums));
    }
}