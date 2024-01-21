import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100181Tests {
    private final Solution100181 solution100181 = new Solution100181();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 12};
        int expected = 6;
        Assertions.assertEquals(expected, solution100181.minimumCost(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 4, 3};
        int expected = 12;
        Assertions.assertEquals(expected, solution100181.minimumCost(nums));
    }

    @Test
    public void example3() {
        int[] nums = {10, 3, 1, 1};
        int expected = 12;
        Assertions.assertEquals(expected, solution100181.minimumCost(nums));
    }
}