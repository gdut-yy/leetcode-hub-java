import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4016Tests {
    private final Solution4016 solution4016 = new Solution4016();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,1,1,0],[1,1,1,1],[0,0,1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution4016.maxArea(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution4016.maxArea(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[0,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution4016.maxArea(mat));
    }
}