import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR146Tests {
    private final SolutionLCR146 solutionLCR146 = new SolutionLCR146();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        Assertions.assertArrayEquals(expected, solutionLCR146.spiralArray(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        int[] expected = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solutionLCR146.spiralArray(matrix));
    }
}
