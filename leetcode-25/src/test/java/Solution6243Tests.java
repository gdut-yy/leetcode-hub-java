import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6243Tests {
    private final Solution6243 solution6243 = new Solution6243();

    @Test
    public void example1() {
        int[][] roads = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int seats = 5;
        long expected = 3;
        Assertions.assertEquals(expected, solution6243.minimumFuelCost(roads, seats));
    }

    @Test
    public void example2() {
        int[][] roads = UtUtils.stringToInts2("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]");
        int seats = 2;
        long expected = 7;
        Assertions.assertEquals(expected, solution6243.minimumFuelCost(roads, seats));
    }

    @Test
    public void example3() {
        int[][] roads = UtUtils.stringToInts2("[]");
        int seats = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution6243.minimumFuelCost(roads, seats));
    }
}
