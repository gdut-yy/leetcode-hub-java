import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionO03Tests {
    private final SolutionO03 solutionO03 = new SolutionO03();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        List<Integer> expectedList = List.of(2, 3);
        Assertions.assertTrue(expectedList.contains(solutionO03.findRepeatNumber(nums)));
    }
}
