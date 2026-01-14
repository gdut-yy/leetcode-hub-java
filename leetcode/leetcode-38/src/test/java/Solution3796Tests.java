import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3796Tests {
    private final Solution3796 solution3796 = new Solution3796();

    @Test
    public void example1() {
        int n = 10;
        int[][] restrictions = UtUtils.stringToInts2("[[3,1],[8,1]]");
        int[] diff = {2, 2, 3, 1, 4, 5, 1, 1, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution3796.findMaxVal(n, restrictions, diff));
    }

    @Test
    public void example2() {
        int n = 8;
        int[][] restrictions = UtUtils.stringToInts2("[[3,2]]");
        int[] diff = {3, 5, 2, 4, 2, 3, 1};
        int expected = 12;
        Assertions.assertEquals(expected, solution3796.findMaxVal(n, restrictions, diff));
    }
}