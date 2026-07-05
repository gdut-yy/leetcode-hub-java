import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3933Tests {
    private final Solution3933 solution = new Solution3933();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,2,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution.countLocalMaximums(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution.countLocalMaximums(matrix));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[1,0,1],[0,1,0],[1,0,1]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution.countLocalMaximums(matrix));
    }

    @Test
    public void example4() {
        int[][] matrix = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution.countLocalMaximums(matrix));
    }
}