import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1966Tests {
    private final Solution1966 solution1966 = new Solution1966();

    @Test
    public void example1() {
        int[] nums = {7};
        int expected = 1;
        Assertions.assertEquals(expected, solution1966.binarySearchableNumbers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 5, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1966.binarySearchableNumbers(nums));
    }
}