import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3873Tests {
    private final Solution3873 solution3873 = new Solution3873();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[1,2],[2,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3873.maxActivated(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[2,2],[1,1],[3,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3873.maxActivated(points));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[2,3],[2,2],[1,1],[4,5]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3873.maxActivated(points));
    }
}