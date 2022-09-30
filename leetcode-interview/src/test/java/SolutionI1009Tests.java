import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1009Tests {
    private final SolutionI1009 solutionI1009 = new SolutionI1009();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("""
                [
                  [1,   4,  7, 11, 15],
                  [2,   5,  8, 12, 19],
                  [3,   6,  9, 16, 22],
                  [10, 13, 14, 17, 24],
                  [18, 21, 23, 26, 30]
                ]
                """);
        int target = 5;
        Assertions.assertTrue(solutionI1009.searchMatrix(matrix, target));
    }
}
