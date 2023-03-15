import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO45Tests {
    private final SolutionO45 solutionO45 = new SolutionO45();

    @Test
    public void example1() {
        int[] nums = {10, 2};
        String expected = "102";
        Assertions.assertEquals(expected, solutionO45.minNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 30, 34, 5, 9};
        String expected = "3033459";
        Assertions.assertEquals(expected, solutionO45.minNumber(nums));
    }
}
