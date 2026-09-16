import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4044Tests {
    private final Solution4044 solution4044 = new Solution4044();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution4044.countGoodRotations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution4044.countGoodRotations(nums));
    }
}