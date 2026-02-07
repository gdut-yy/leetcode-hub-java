import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3632Tests {
    private final SolutionP3632 solutionP3632 = new SolutionP3632();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2, 3};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3632.countXorSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0};
        int k = 0;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3632.countXorSubarrays(nums, k));
    }
}