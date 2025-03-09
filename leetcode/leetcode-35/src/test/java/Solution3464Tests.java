import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3464Tests {
    private final Solution3464 solution3464 = new Solution3464();

    @Test
    public void example1() {
        int side = 2;
        int[][] points = UtUtils.stringToInts2("[[0,2],[2,0],[2,2],[0,0]]");
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution3464.maxDistance(side, points, k));
    }

    @Test
    public void example2() {
        int side = 2;
        int[][] points = UtUtils.stringToInts2("[[0,0],[1,2],[2,0],[2,2],[2,1]]");
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution3464.maxDistance(side, points, k));
    }

    @Test
    public void example3() {
        int side = 2;
        int[][] points = UtUtils.stringToInts2("[[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]]");
        int k = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution3464.maxDistance(side, points, k));
    }
}