import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4093Tests {
    private final Solution4093 solution4093 = new Solution4093();

    @Test
    public void example1() {
        int[] nums = {123, 45};
        int k = 1;
        long expected = 366;
        Assertions.assertEquals(expected, solution4093.maximizeSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {102, 90, 14};
        int k = 2;
        long expected = 341;
        Assertions.assertEquals(expected, solution4093.maximizeSum(nums, k));
    }
}
