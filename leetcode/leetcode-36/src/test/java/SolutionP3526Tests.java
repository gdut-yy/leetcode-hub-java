import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3526Tests {
    private final SolutionP3526 solutionP3526 = new SolutionP3526();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] queries = UtUtils.stringToInts2("[[2,1,3],[1,2,10],[3,0,4],[2,0,4]]");
        int[] expected = {5, 8};
        Assertions.assertArrayEquals(expected, solutionP3526.getResults(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {7, 8, 9};
        int[][] queries = UtUtils.stringToInts2("[[1,0,3],[2,0,2],[3,1,2]]");
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solutionP3526.getResults(nums, queries));
    }
}