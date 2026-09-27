import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3907Tests {
    private final SolutionP3907 solutionP3907 = new SolutionP3907();

    @Test
    public void example1() {
        int[] nums = UtUtils.stringToInts("[5,2,4,1,3]");
        int[] expected = {2, 1, 2, 0, 0};
        Assertions.assertArrayEquals(expected, solutionP3907.countSmallerOppositeParity(nums));
    }

    @Test
    public void example2() {
        int[] nums = UtUtils.stringToInts("[4,4,1]");
        int[] expected = {1, 1, 0};
        Assertions.assertArrayEquals(expected, solutionP3907.countSmallerOppositeParity(nums));
    }

    @Test
    public void example3() {
        int[] nums = UtUtils.stringToInts("[7]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solutionP3907.countSmallerOppositeParity(nums));
    }
}
