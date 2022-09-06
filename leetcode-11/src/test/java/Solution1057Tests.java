import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1057Tests {
    private final Solution1057 solution1057 = new Solution1057();

    @Test
    public void example1() {
        int[][] workers = UtUtils.stringToInts2("[[0,0],[2,1]]");
        int[][] bikes = UtUtils.stringToInts2("[[1,2],[3,3]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution1057.assignBikes(workers, bikes));
    }

    @Test
    public void example2() {
        int[][] workers = UtUtils.stringToInts2("[[0,0],[1,1],[2,0]]");
        int[][] bikes = UtUtils.stringToInts2("[[1,0],[2,2],[2,1]]");
        int[] expected = {0, 2, 1};
        Assertions.assertArrayEquals(expected, solution1057.assignBikes(workers, bikes));
    }
}
