import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0803Tests {
    private final SolutionI0803 solutionI0803 = new SolutionI0803();

    @Test
    public void example1() {
        int[] nums = {0, 2, 3, 4, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solutionI0803.findMagicIndex(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solutionI0803.findMagicIndex(nums));
    }
}
