import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution486Tests {
    private final Solution486.V1 solution486_v1 = new Solution486.V1();
    private final Solution486.V2 solution486_v2 = new Solution486.V2();

    @Test
    public void example1() {
        int[] nums = {1, 5, 2};
        Assertions.assertFalse(solution486_v1.predictTheWinner(nums));
        Assertions.assertFalse(solution486_v2.predictTheWinner(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 233, 7};
        Assertions.assertTrue(solution486_v1.predictTheWinner(nums));
        Assertions.assertTrue(solution486_v2.predictTheWinner(nums));
    }
}
