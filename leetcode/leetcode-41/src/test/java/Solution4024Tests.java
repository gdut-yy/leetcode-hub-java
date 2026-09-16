import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4024Tests {
    private final Solution4024 solution4024 = new Solution4024();

    @Test
    public void example1() {
        int[][] drones = UtUtils.stringToInts2("[[0,0,8],[2,2,9]]");
        int[] target = {3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution4024.nearestDrone(drones, target));
    }

    @Test
    public void example2() {
        int[][] drones = UtUtils.stringToInts2("[[2,1,5],[4,4,5],[6,6,8]]");
        int[] target = {5, 5};
        int expected = 1;
        Assertions.assertEquals(expected, solution4024.nearestDrone(drones, target));
    }

    @Test
    public void example3() {
        int[][] drones = UtUtils.stringToInts2("[[4,4,5]]");
        int[] target = {8, 6};
        int expected = -1;
        Assertions.assertEquals(expected, solution4024.nearestDrone(drones, target));
    }
}