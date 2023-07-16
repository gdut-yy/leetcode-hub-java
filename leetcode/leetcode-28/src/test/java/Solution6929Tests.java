import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6929Tests {
    private final Solution6929 solution6929 = new Solution6929();

    @Test
    public void example1() {
        int[] nums = {4, 6, 1, 2};
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution6929.maximumBeauty(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        int k = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution6929.maximumBeauty(nums, k));
    }
}