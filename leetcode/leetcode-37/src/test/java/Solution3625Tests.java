import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3625Tests {
    private final Solution3625 solution3625 = new Solution3625();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[-3,2],[3,0],[2,3],[3,2],[2,-3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3625.countTrapezoids(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[1,0],[0,1],[2,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3625.countTrapezoids(points));
    }
}