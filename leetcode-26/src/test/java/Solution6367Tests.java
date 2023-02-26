import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6367Tests {
    private final Solution6367 solution6367 = new Solution6367();

    @Test
    public void example1() {
        int[] nums = {3, 5, 2, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution6367.maxNumOfMarkedIndices(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 2, 5, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution6367.maxNumOfMarkedIndices(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 6, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution6367.maxNumOfMarkedIndices(nums));
    }
}