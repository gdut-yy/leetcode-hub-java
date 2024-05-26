import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100309Tests {
    private final Solution100309 solution100309 = new Solution100309();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution100309.duplicateNumbersXOR(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution100309.duplicateNumbersXOR(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution100309.duplicateNumbersXOR(nums));
    }
}