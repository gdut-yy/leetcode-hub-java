import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3972Tests {
    private final SolutionP3972 solutionP3972 = new SolutionP3972();

    @Test
    public void example1() {
        int[] nums = {1, 100, 1};
        int x = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3972.countValidSubarrays(nums, x));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int x = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3972.countValidSubarrays(nums, x));
    }
}
