import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6103Tests {
    private final Solution6103 solution6103 = new Solution6103();

    @Test
    public void example1() {
        int[] nums = {1, 5, 5, 4, 11};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[3,4]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution6103.minimumScore(nums, edges));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 2, 4, 4, 2};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[5,2],[4,3],[1,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution6103.minimumScore(nums, edges));
    }
}
