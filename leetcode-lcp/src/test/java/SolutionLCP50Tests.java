import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP50Tests {
    private final SolutionLCP50 solutionLCP50 = new SolutionLCP50();

    @Test
    public void example1() {
        int[] gem = {3, 1, 2};
        int[][] operations = UtUtils.stringToInts2("[[0,2],[2,1],[2,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP50.giveGem(gem, operations));
    }

    @Test
    public void example2() {
        int[] gem = {100, 0, 50, 100};
        int[][] operations = UtUtils.stringToInts2("[[0,2],[0,1],[3,0],[3,0]]");
        int expected = 75;
        Assertions.assertEquals(expected, solutionLCP50.giveGem(gem, operations));
    }

    @Test
    public void example3() {
        int[] gem = {0, 0, 0, 0};
        int[][] operations = UtUtils.stringToInts2("[[1,2],[3,1],[1,2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP50.giveGem(gem, operations));
    }
}
