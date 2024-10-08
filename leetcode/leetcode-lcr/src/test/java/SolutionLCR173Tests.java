import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR173Tests {
    private final SolutionLCR173 solutionLCR173 = new SolutionLCR173();

    @Test
    public void example1() {
        int[] nums = {0, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCR173.takeAttendance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int expected = 8;
        Assertions.assertEquals(expected, solutionLCR173.takeAttendance(nums));
    }
}
