import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1060Tests {
    private final Solution1060 solution1060 = new Solution1060();

    @Test
    public void example1() {
        int[] nums = {4, 7, 9, 10};
        int k = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution1060.missingElement(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 7, 9, 10};
        int k = 3;
        int expected = 8;
        Assertions.assertEquals(expected, solution1060.missingElement(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 4};
        int k = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution1060.missingElement(nums, k));
    }
}
