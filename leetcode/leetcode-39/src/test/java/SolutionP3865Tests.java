import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3865Tests {
    private final SolutionP3865 solutionP3865 = new SolutionP3865();

    @Test
    public void example1() {
        int[] nums = UtUtils.stringToInts("[1,2,4,3,5,6]");
        int k = 3;
        int[] expected = {2, 1, 3, 4, 6, 5};
        Assertions.assertArrayEquals(expected, solutionP3865.reverseSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = UtUtils.stringToInts("[5,4,4,2]");
        int k = 1;
        int[] expected = {2, 4, 4, 5};
        Assertions.assertArrayEquals(expected, solutionP3865.reverseSubarrays(nums, k));
    }
}
