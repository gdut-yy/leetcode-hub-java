import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution480Tests {
    private final Solution480.V1 solution480_v1 = new Solution480.V1();
    private final Solution480.V2 solution480_v2 = new Solution480.V2();

    @Test
    public void example1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] expected = {1, -1, -1, 3, 5, 6};
        Assertions.assertArrayEquals(expected, solution480_v1.medianSlidingWindow(nums, k));
        Assertions.assertArrayEquals(expected, solution480_v2.medianSlidingWindow(nums, k));
    }
}