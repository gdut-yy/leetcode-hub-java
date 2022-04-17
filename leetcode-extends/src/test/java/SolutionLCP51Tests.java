import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP51Tests {
    private final SolutionLCP51 solutionLCP51 = new SolutionLCP51();

    @Test
    public void example1() {
        int[] materials = {3, 2, 4, 1, 2};
        int[][] cookbooks = UtUtils.stringToInts2("[[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]]");
        int[][] attribute = UtUtils.stringToInts2("[[3,2],[2,4],[7,6]]");
        int limit = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solutionLCP51.perfectMenu(materials, cookbooks, attribute, limit));
    }

    @Test
    public void example2() {
        int[] materials = {10, 10, 10, 10, 10};
        int[][] cookbooks = UtUtils.stringToInts2("[[1,1,1,1,1],[3,3,3,3,3],[10,10,10,10,10]]");
        int[][] attribute = UtUtils.stringToInts2("[[5,5],[6,6],[10,10]]");
        int limit = 1;
        int expected = 11;
        Assertions.assertEquals(expected, solutionLCP51.perfectMenu(materials, cookbooks, attribute, limit));
    }
}
