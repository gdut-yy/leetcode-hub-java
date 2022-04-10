import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6039Tests {
    private final Solution6039 solution6039 = new Solution6039();

    @Test
    public void example1() {
        int[] nums = {0, 4};
        int k = 5;
        int expected = 20;
        Assertions.assertEquals(expected, solution6039.maximumProduct(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {6, 3, 3, 2};
        int k = 2;
        int expected = 216;
        Assertions.assertEquals(expected, solution6039.maximumProduct(nums, k));
    }
}
