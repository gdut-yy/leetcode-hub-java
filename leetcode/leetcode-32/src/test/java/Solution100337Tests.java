import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100337Tests {
    private final Solution100337 solution100337 = new Solution100337();

    @Test
    public void example1() {
        int[] nums = {1, -2, 3, 4};
        long expected = 10;
        Assertions.assertEquals(expected, solution100337.maximumTotalCost(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, -1, 1, -1};
        long expected = 4;
        Assertions.assertEquals(expected, solution100337.maximumTotalCost(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        long expected = 0;
        Assertions.assertEquals(expected, solution100337.maximumTotalCost(nums));
    }

    @Test
    public void example4() {
        int[] nums = {1, -1};
        long expected = 2;
        Assertions.assertEquals(expected, solution100337.maximumTotalCost(nums));
    }
}