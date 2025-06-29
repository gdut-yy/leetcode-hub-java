import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3588Tests {
    private final Solution3588 solution3588 = new Solution3588();

    @Test
    public void example1() {
        int[][] coords = UtUtils.stringToInts2("[[1,1],[1,2],[3,2],[3,3]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution3588.maxArea(coords));
    }

    @Test
    public void example2() {
        int[][] coords = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        long expected = -1;
        Assertions.assertEquals(expected, solution3588.maxArea(coords));
    }
}