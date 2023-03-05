import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1114Tests {
    private final Solution1114 solution1114 = new Solution1114();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution1114.movesToMakeZigzag(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 6, 1, 6, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution1114.movesToMakeZigzag(nums));
    }
}