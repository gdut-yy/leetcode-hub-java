import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3837Tests {
    private final SolutionP3837 solutionP3837 = new SolutionP3837();

    @Test
    public void example1() {
        int[] nums = UtUtils.stringToInts("[1,2,1,1]");
        int k = 1;
        int[] expected = {2, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solutionP3837.delayedCount(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = UtUtils.stringToInts("[3,1,3,1]");
        int k = 0;
        int[] expected = {1, 1, 0, 0};
        Assertions.assertArrayEquals(expected, solutionP3837.delayedCount(nums, k));
    }
}
