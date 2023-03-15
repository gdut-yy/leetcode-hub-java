import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO29Tests {
    private final SolutionO29 solutionO29 = new SolutionO29();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        Assertions.assertArrayEquals(expected, solutionO29.spiralOrder(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        int[] expected = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solutionO29.spiralOrder(matrix));
    }
}
