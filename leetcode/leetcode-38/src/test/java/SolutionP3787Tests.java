import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3787Tests {
    private final SolutionP3787 solutionP3787 = new SolutionP3787();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        String expected = "101";
        Assertions.assertEquals(expected, solutionP3787.findSpecialNodes(n, edges));
    }
    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4],[3,5],[1,6]]");
        String expected = "1000111";
        Assertions.assertEquals(expected, solutionP3787.findSpecialNodes(n, edges));
    }
    @Test
    public void example3() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        String expected = "11";
        Assertions.assertEquals(expected, solutionP3787.findSpecialNodes(n, edges));
    }
}