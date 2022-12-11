import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6257Tests {
    private final Solution6257 solution6257 = new Solution6257();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,4],[3,3,1]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution6257.deleteGreatestValue(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[10]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution6257.deleteGreatestValue(grid));
    }
}
