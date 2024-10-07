import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR158Tests {
    private final SolutionLCR158 solutionLCR158 = new SolutionLCR158();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCR158.inventoryManagement(nums));
        Assertions.assertEquals(expected, solutionLCR158.inventoryManagement2(nums));
    }
}
