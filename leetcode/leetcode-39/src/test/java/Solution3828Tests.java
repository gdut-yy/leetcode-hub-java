import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3828Tests {
    private final Solution3828 solution3828 = new Solution3828();

    @Test
    public void example1() {
        int[] nums = {1, 5, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3828.finalElement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 7};
        int expected = 7;
        Assertions.assertEquals(expected, solution3828.finalElement(nums));
    }
}