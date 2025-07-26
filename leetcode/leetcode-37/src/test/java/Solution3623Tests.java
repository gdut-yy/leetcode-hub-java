import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3623Tests {
    private final Solution3623 solution3623 = new Solution3623();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,0],[2,0],[3,0],[2,2],[3,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3623.countTrapezoids(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[1,0],[0,1],[2,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3623.countTrapezoids(points));
    }
}