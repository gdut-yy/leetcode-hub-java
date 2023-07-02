import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1619Tests {
    private final SolutionI1619 solutionI1619 = new SolutionI1619();

    @Test
    public void example1() {
        int[][] land = UtUtils.stringToInts2("[[0,2,1,0],[0,1,0,1],[1,1,0,1],[0,1,0,1]]");
        int[] expected = {1, 2, 4};
        Assertions.assertArrayEquals(expected, solutionI1619.pondSizes(land));
    }
}