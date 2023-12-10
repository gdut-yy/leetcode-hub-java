import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution100155Tests {
    private final Solution100155 solution100155 = new Solution100155();

    @Test
    public void example1() {
        int[][] variables = UtUtils.stringToInts2("[[2,3,3,10],[3,3,3,1],[6,1,1,4]]");
        int target = 2;
        List<Integer> expected = Arrays.asList(0, 2);
        Assertions.assertEquals(expected, solution100155.getGoodIndices(variables, target));
    }

    @Test
    public void example2() {
        int[][] variables = UtUtils.stringToInts2("[[39,3,1000,1000]]");
        int target = 17;
        List<Integer> expected = Arrays.asList();
        Assertions.assertEquals(expected, solution100155.getGoodIndices(variables, target));
    }
}