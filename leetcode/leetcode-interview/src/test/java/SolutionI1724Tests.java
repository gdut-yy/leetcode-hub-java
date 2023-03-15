import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1724Tests {
    private final SolutionI1724 solutionI1724 = new SolutionI1724();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("""
                [
                   [-1,0],
                   [0,-1]
                ]
                """);
        int[] expected = {0, 1, 0, 1};
        Assertions.assertArrayEquals(expected, solutionI1724.getMaxMatrix(matrix));
    }
}
