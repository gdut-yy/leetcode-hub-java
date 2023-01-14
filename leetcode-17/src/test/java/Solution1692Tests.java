import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1692Tests {
    private final Solution1692 solution1692 = new Solution1692();

    @Test
    public void example1() {
        int n = 3;
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution1692.waysToDistribute(n, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution1692.waysToDistribute(n, k));
    }

    @Test
    public void example3() {
        int n = 20;
        int k = 5;
        int expected = 206085257;
        Assertions.assertEquals(expected, solution1692.waysToDistribute(n, k));
    }
}
