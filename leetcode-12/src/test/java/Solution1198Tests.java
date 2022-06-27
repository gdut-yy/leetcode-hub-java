import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1198Tests {
    private final Solution1198 solution1198 = new Solution1198();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution1198.smallestCommonElement(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,3],[2,3,4],[2,3,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1198.smallestCommonElement(mat));
    }
}
