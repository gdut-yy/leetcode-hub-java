import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3595Tests {
    private final SolutionP3595 solutionP3595 = new SolutionP3595();

    @Test
    public void example1() {
        int[] nums = {2, 2, 3, 2, 5, 5, 5, 7, 7};
        int[] expected = {3, 7};
        Assertions.assertArrayEquals(expected, solutionP3595.onceTwice(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 6, 4, 9, 9, 9, 6, 8};
        int[] expected = {8, 6};
        Assertions.assertArrayEquals(expected, solutionP3595.onceTwice(nums));
    }
}