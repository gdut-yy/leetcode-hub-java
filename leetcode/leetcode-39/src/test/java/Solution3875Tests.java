import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3875Tests {
    private final Solution3875 solution3875 = new Solution3875();

    @Test
    public void example1() {
        int[] nums1 = {2, 3};
        Assertions.assertTrue(solution3875.uniformArray(nums1));
    }

    @Test
    public void example2() {
        int[] nums1 = {4, 6};
        Assertions.assertTrue(solution3875.uniformArray(nums1));
    }
}