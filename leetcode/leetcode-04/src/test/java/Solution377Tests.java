import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution377Tests {
    private final Solution377 solution377 = new Solution377();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int target = 4;
        int expected = 7;
        Assertions.assertEquals(expected, solution377.combinationSum4(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {9};
        int target = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution377.combinationSum4(nums, target));
    }
}
