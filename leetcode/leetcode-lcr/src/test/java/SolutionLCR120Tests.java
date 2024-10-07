import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionLCR120Tests {
    private final SolutionLCR120 solutionLCR120 = new SolutionLCR120();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        List<Integer> expectedList = List.of(2, 3);
        Assertions.assertTrue(expectedList.contains(solutionLCR120.findRepeatDocument(nums)));
    }
}
