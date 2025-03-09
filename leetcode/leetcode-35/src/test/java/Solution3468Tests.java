import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3468Tests {
    private final Solution3468 solution3468 = new Solution3468();

    @Test
    public void example1() {
        int[] original = {1, 2, 3, 4};
        int[][] bounds = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3468.countArrays(original, bounds));
    }

    @Test
    public void example2() {
        int[] original = {1, 2, 3, 4};
        int[][] bounds = UtUtils.stringToInts2("[[1,10],[2,9],[3,8],[4,7]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3468.countArrays(original, bounds));
    }

    @Test
    public void example3() {
        int[] original = {1, 2, 1, 2};
        int[][] bounds = UtUtils.stringToInts2("[[1,1],[2,3],[3,3],[2,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3468.countArrays(original, bounds));
    }
}