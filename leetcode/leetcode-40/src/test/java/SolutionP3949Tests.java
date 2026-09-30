import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3949Tests {
    private final SolutionP3949 solutionP3949 = new SolutionP3949();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[1,4],[1,5]]");
        int[] nums = {1, 0, -10, 3, 4, 5};
        int k = 2;
        int expected = 23;
        Assertions.assertEquals(expected, solutionP3949.subtreeInversionSum(edges, nums, k));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] nums = {5, -10, -10};
        int k = 1;
        int expected = 25;
        Assertions.assertEquals(expected, solutionP3949.subtreeInversionSum(edges, nums, k));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] nums = {1, -5, -6};
        int k = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solutionP3949.subtreeInversionSum(edges, nums, k));
    }

    @Test
    public void example4() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] nums = {1, -5, -6};
        int k = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solutionP3949.subtreeInversionSum(edges, nums, k));
    }
}
