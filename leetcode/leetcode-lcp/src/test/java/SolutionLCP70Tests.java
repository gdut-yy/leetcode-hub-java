import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP70Tests {
    private final SolutionLCP70 solutionLCP70 = new SolutionLCP70();

    @Test
    public void example1() {
        int size = 3;
        int[][] expected = UtUtils.stringToInts2("[[1,1],[2,1],[2,3],[3,1],[3,5]]");
        Assertions.assertEquals(expected.length, solutionLCP70.sandyLandManagement(size).length);
    }

    @Test
    public void example2() {
        int size = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,1],[2,1],[2,3]]");
        Assertions.assertEquals(expected.length, solutionLCP70.sandyLandManagement(size).length);
    }

    // 补充用例
    @Test
    public void example3() {
        int size = 5;
        int[][] expected = UtUtils.stringToInts2("[[1,1],[2,1],[3,3],[3,5],[4,2],[5,1],[5,3],[5,5],[5,7],[5,9]]");
        Assertions.assertEquals(expected.length, solutionLCP70.sandyLandManagement(size).length);
    }

    @Test
    public void example4() {
        int size = 10;
        int[][] expected = UtUtils.stringToInts2("[[1,1],[2,1],[2,3],[3,1],[4,3],[4,5],[4,7],[5,2],[6,1],[6,3],[6,5],[6,7],[6,9],[6,11],[7,1],[8,3],[8,5],[8,7],[8,9],[8,11],[8,13],[8,15],[9,2],[10,1],[10,3],[10,5],[10,7],[10,9],[10,11],[10,13],[10,15],[10,17],[10,19]]");
        Assertions.assertEquals(expected.length, solutionLCP70.sandyLandManagement(size).length);
    }
}
