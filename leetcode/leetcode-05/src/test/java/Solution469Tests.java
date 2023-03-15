import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution469Tests {
    private final Solution469 solution469 = new Solution469();

    @Test
    public void example1() {
        List<List<Integer>> points = UtUtils.stringToIntegerList2("[[0,0],[0,5],[5,5],[5,0]]");
        Assertions.assertTrue(solution469.isConvex(points));
    }

    @Test
    public void example2() {
        List<List<Integer>> points = UtUtils.stringToIntegerList2("[[0,0],[0,10],[10,10],[10,0],[5,5]]");
        Assertions.assertFalse(solution469.isConvex(points));
    }
}
