import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6716Tests {
    private final Solution6716 solution6716 = new Solution6716();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution6716.mostFrequentEven(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 4, 9, 2, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution6716.mostFrequentEven(nums));
    }

    @Test
    public void example3() {
        int[] nums = {29, 47, 21, 41, 13, 37, 25, 7};
        int expected = -1;
        Assertions.assertEquals(expected, solution6716.mostFrequentEven(nums));
    }
}
