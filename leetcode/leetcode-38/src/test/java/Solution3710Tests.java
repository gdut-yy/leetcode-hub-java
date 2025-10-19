import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3710Tests {
    private final Solution3710 solution3710 = new Solution3710();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[0,2],[2,0],[2,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3710.maxPartitionFactor(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[0,1],[10,0]]");
        int expected = 11;
        Assertions.assertEquals(expected, solution3710.maxPartitionFactor(points));
    }
}