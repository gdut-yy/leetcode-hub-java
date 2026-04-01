import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3858Tests {
    private final Solution3858 solution3858 = new Solution3858();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,5],[2,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3858.minimumOR(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,5],[6,4]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3858.minimumOR(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[7,9,8]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution3858.minimumOR(grid));
    }
}