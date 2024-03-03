import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100237Tests {
    private final Solution100237 solution100237 = new Solution100237();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[7,6,3],[6,6,1]]");
        int k = 18;
        int expected = 4;
        Assertions.assertEquals(expected, solution100237.countSubmatrices(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[7,2,9],[1,5,0],[2,6,6]]");
        int k = 20;
        int expected = 6;
        Assertions.assertEquals(expected, solution100237.countSubmatrices(grid, k));
    }
}