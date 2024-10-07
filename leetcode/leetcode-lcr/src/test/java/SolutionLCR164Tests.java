import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR164Tests {
    private final SolutionLCR164 solutionLCR164 = new SolutionLCR164();

    @Test
    public void example1() {
        int[] nums = {10, 2};
        String expected = "102";
        Assertions.assertEquals(expected, solutionLCR164.crackPassword(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 30, 34, 5, 9};
        String expected = "3033459";
        Assertions.assertEquals(expected, solutionLCR164.crackPassword(nums));
    }
}
