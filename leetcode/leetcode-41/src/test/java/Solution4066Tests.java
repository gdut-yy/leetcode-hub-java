import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4066Tests {
    private final Solution4066 solution4066 = new Solution4066();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution4066.maxEqualAdjacentPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution4066.maxEqualAdjacentPairs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution4066.maxEqualAdjacentPairs(nums));
    }
}
