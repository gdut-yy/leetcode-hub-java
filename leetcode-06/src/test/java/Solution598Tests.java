import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution598Tests {
    private final Solution598 solution598 = new Solution598();

    @Test
    public void example1() {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        int expected = 4;
        Assertions.assertEquals(expected, solution598.maxCount(m, n, ops));
    }
}
