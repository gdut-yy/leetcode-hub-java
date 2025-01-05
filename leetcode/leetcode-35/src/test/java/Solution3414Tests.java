import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3414Tests {
    private final Solution3414 solution3414 = new Solution3414();

    @Test
    public void example1() {
        List<List<Integer>> intervals = UtUtils.stringToIntegerList2("[[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]");
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution3414.maximumWeight(intervals));
    }

    @Test
    public void example2() {
        List<List<Integer>> intervals = UtUtils.stringToIntegerList2("[[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]");
        int[] expected = {1, 3, 5, 6};
        Assertions.assertArrayEquals(expected, solution3414.maximumWeight(intervals));
    }
}