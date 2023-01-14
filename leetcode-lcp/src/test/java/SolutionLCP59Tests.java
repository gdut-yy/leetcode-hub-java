import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP59Tests {
    private final SolutionLCP59 solutionLCP59 = new SolutionLCP59();

    @Test
    public void example1() {
        int num = 10;
        int[][] wood = UtUtils.stringToInts2("[[1,2],[4,7],[8,9]]");
        long expected = 3;
        Assertions.assertEquals(expected, solutionLCP59.buildBridge(num, wood));
    }

    @Test
    public void example2() {
        int num = 10;
        int[][] wood = UtUtils.stringToInts2("[[1,5],[1,1],[10,10],[6,7],[7,8]]");
        long expected = 10;
        Assertions.assertEquals(expected, solutionLCP59.buildBridge(num, wood));
    }

    @Test
    public void example3() {
        int num = 5;
        int[][] wood = UtUtils.stringToInts2("[[1,2],[2,4]]");
        long expected = 0;
        Assertions.assertEquals(expected, solutionLCP59.buildBridge(num, wood));
    }
}
