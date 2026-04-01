import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3845Tests {
    private final Solution3845 solution3845 = new Solution3845();

    @Test
    public void example1() {
        int[] nums = {5, 4, 5, 6};
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution3845.maxXor(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 4, 5, 6};
        int k = 1;
        int expected = 6;
        Assertions.assertEquals(expected, solution3845.maxXor(nums, k));
    }
}