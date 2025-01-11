import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3404Tests {
    private final Solution3404 solution3404 = new Solution3404();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 3, 6, 1};
        long expected = 1;
        Assertions.assertEquals(expected, solution3404.numberOfSubsequences(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 3, 4, 3, 4, 3, 4};
        long expected = 3;
        Assertions.assertEquals(expected, solution3404.numberOfSubsequences(nums));
    }
}