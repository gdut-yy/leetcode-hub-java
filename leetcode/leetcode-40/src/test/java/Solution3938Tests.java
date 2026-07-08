import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3938Tests {
    private final Solution3938 solution3938 = new Solution3938();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,0,-3],[1,-2,1,0],[-4,2,-1,3],[3,-3,3,-2],[-1,-5,0,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3938.maxScore(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[4,-2,-3],[-1,-3,-1],[-4,2,-1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3938.maxScore(grid));
    }
}