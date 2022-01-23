import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5992Tests {
    private final Solution5992 solution5992 = new Solution5992();

    @Test
    public void example1() {
        int[][] statements = {{2, 1, 2}, {1, 2, 2}, {2, 0, 2}};
        int expected = 2;
        Assertions.assertEquals(expected, solution5992.maximumGood(statements));
    }

    @Test
    public void example2() {
        int[][] statements = {{2, 0}, {0, 2}};
        int expected = 1;
        Assertions.assertEquals(expected, solution5992.maximumGood(statements));
    }
}
