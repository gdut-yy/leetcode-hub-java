import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3923Tests {
    private final Solution3923 solution3923 = new Solution3923();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[0,0,0],[6,6,6]]");
        int[] target = {3, 3, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution3923.minGenerations(points, target));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,0,0],[5,5,5]]");
        int[] target = {1, 1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3923.minGenerations(points, target));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[0,0,0],[2,2,2],[3,3,3]]");
        int[] target = {2, 2, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution3923.minGenerations(points, target));
    }
}