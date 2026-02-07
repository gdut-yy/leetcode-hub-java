import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3511Tests {
    private final SolutionP3511 solutionP3511 = new SolutionP3511();

    @Test
    public void example1() {
        int[] nums = {-10, 15, -12};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3511.makeArrayPositive(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, -2, 3, -1, 2, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3511.makeArrayPositive(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3511.makeArrayPositive(nums));
    }
}