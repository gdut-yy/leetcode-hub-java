import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100315Tests {
    private final Solution100315 solution100315 = new Solution100315();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4, 5};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution100315.minimumDifference(nums, k));
        Assertions.assertEquals(expected, solution100315.minimumDifference2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution100315.minimumDifference(nums, k));
        Assertions.assertEquals(expected, solution100315.minimumDifference2(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int k = 10;
        int expected = 9;
        Assertions.assertEquals(expected, solution100315.minimumDifference(nums, k));
        Assertions.assertEquals(expected, solution100315.minimumDifference2(nums, k));
    }
}