import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4097Tests {
    private final Solution4097 solution4097 = new Solution4097();

    @Test
    public void example1() {
        int[] nums = {23, 55, 42, 21};
        int expected = 2355;
        Assertions.assertEquals(expected, solution4097.minMergedInteger(nums));
    }

    @Test
    public void example2() {
        int[] nums = {34, 7, 11, 11};
        int expected = 347;
        Assertions.assertEquals(expected, solution4097.minMergedInteger(nums));
    }

    @Test
    public void example3() {
        int[] nums = {9, 20};
        int expected = 920;
        Assertions.assertEquals(expected, solution4097.minMergedInteger(nums));
    }
}
