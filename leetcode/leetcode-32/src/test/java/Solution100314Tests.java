import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution100314Tests {
    private final Solution100314 solution100314 = new Solution100314();

    @Test
    public void example1() {
        int[][] queries = UtUtils.stringToInts2("[[1,2],[2,3,3],[2,3,1],[2,2,2]]");
        List<Boolean> expected = List.of(false, true, true);
        Assertions.assertEquals(expected, solution100314.getResults(queries));
    }

    @Test
    public void example2() {
        int[][] queries = UtUtils.stringToInts2("[[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]");
        List<Boolean> expected = List.of(true, true, false);
        Assertions.assertEquals(expected, solution100314.getResults(queries));
    }
}