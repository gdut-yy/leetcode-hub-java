import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3531Tests {
    private final Solution3531 solution3531 = new Solution3531();

    @Test
    public void example1() {
        int n = 3;
        int[][] buildings = UtUtils.stringToInts2("[[1,2],[2,2],[3,2],[2,1],[2,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3531.countCoveredBuildings(n, buildings));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] buildings = UtUtils.stringToInts2("[[1,1],[1,2],[2,1],[2,2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3531.countCoveredBuildings(n, buildings));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] buildings = UtUtils.stringToInts2("[[1,3],[3,2],[3,3],[3,5],[5,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3531.countCoveredBuildings(n, buildings));
    }
}