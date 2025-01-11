import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3380Tests {
    private final Solution3380 solution3380 = new Solution3380();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[1,3],[3,1],[3,3]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3380.maxRectangleArea(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[1,3],[3,1],[3,3],[2,2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution3380.maxRectangleArea(points));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[1,3],[3,1],[3,3],[1,2],[3,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3380.maxRectangleArea(points));
    }
}