import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3528Tests {
    private final Solution3528 solution3528 = new Solution3528();

    @Test
    public void example1() {
        int[][] conversions = UtUtils.stringToInts2("[[0,1,2],[1,2,3]]");
        int[] expected = {1, 2, 6};
        Assertions.assertArrayEquals(expected, solution3528.baseUnitConversions(conversions));
    }

    @Test
    public void example2() {
        int[][] conversions = UtUtils.stringToInts2("[[0,1,2],[0,2,3],[1,3,4],[1,4,5],[2,5,2],[4,6,3],[5,7,4]]");
        int[] expected = {1, 2, 3, 8, 10, 6, 30, 24};
        Assertions.assertArrayEquals(expected, solution3528.baseUnitConversions(conversions));
    }
}