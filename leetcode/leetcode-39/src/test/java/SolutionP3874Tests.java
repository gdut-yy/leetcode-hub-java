import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3874Tests {
    private final SolutionP3874 solutionP3874 = new SolutionP3874();

    @Test
    public void example1() {
        int[] nums = UtUtils.stringToInts("[1,3,2]");
        int k = 1;
        long expected = 4;
        Assertions.assertEquals(expected, solutionP3874.validSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = UtUtils.stringToInts("[7,8,9]");
        int k = 2;
        long expected = 0;
        Assertions.assertEquals(expected, solutionP3874.validSubarrays(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = UtUtils.stringToInts("[4,3,5,1]");
        int k = 2;
        long expected = 6;
        Assertions.assertEquals(expected, solutionP3874.validSubarrays(nums, k));
    }
}
