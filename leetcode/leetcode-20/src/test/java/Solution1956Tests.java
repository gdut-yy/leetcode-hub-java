import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1956Tests {
    private final Solution1956 solution1956 = new Solution1956();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[6,1]]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution1956.minDayskVariants(points, k));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[3,3],[1,2],[9,2]]");
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1956.minDayskVariants(points, k));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[3,3],[1,2],[9,2]]");
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution1956.minDayskVariants(points, k));
    }
}