import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3667Tests {
    private final SolutionP3667 solutionP3667s = new SolutionP3667();

    @Test
    public void example1() {
        int[] nums = {3, -1, -4, 1, 5};
        int[] expected = {-1, 1, 3, -4, 5};
        Assertions.assertArrayEquals(expected, solutionP3667s.sortByAbsoluteValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-100, 100};
        int[] expected = {-100, 100};
        Assertions.assertArrayEquals(expected, solutionP3667s.sortByAbsoluteValue(nums));
    }
}