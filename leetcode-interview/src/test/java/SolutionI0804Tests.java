import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionI0804Tests {
    private final SolutionI0804 solutionI0804 = new SolutionI0804();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(1), List.of(2),
                List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3)));
        List<List<Integer>> actual = solutionI0804.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
