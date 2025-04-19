import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3510Tests {
    private final Solution3510.V1 solution3510_v1 = new Solution3510.V1();
    private final Solution3510.V2 solution3510_v2 = new Solution3510.V2();

    @Test
    public void example1() {
        int[] nums = {5, 2, 3, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3510_v1.minimumPairRemoval(nums));
        Assertions.assertEquals(expected, solution3510_v2.minimumPairRemoval(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution3510_v1.minimumPairRemoval(nums));
        Assertions.assertEquals(expected, solution3510_v2.minimumPairRemoval(nums));
    }
}