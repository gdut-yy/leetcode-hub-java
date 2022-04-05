import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution305Tests {
    private final Solution305 solution305 = new Solution305();

    @Test
    public void example1() {
        int m = 3;
        int n = 3;
        int[][] positions = UtUtils.stringToInts2("[[0,0],[0,1],[1,2],[2,1]]");
        List<Integer> expected = List.of(1, 1, 2, 3);
        Assertions.assertEquals(expected, solution305.numIslands2(m, n, positions));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 1;
        int[][] positions = UtUtils.stringToInts2("[[0,0]]");
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution305.numIslands2(m, n, positions));
    }
}
