import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP28Tests {
    private final SolutionLCP28 solutionLCP28 = new SolutionLCP28();

    @Test
    public void example1() {
        int[] nums = {2, 5, 3, 5};
        int target = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP28.purchasePlans(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 1, 9};
        int target = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP28.purchasePlans(nums, target));
    }
}
