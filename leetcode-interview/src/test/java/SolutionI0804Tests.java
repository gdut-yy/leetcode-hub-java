import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionI0804Tests {
    private final SolutionI0804 solutionI0804 = new SolutionI0804();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                  [3],
                  [1],
                  [2],
                  [1,2,3],
                  [1,3],
                  [2,3],
                  [1,2],
                  []
                ]
                """);
        List<List<Integer>> actual = solutionI0804.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
