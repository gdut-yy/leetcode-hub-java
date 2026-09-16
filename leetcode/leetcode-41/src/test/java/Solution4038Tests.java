import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4038Tests {
    private final Solution4038 solution4038 = new Solution4038();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution4038.countSpecialIntegers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 1, 2, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution4038.countSpecialIntegers(nums));
    }
}