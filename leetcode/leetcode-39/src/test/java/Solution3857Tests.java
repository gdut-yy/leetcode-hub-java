import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3857Tests {
    private final Solution3857 solution3857 = new Solution3857();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3857.minCost(n));
    }

    @Test
    public void example2() {
        int n = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution3857.minCost(n));
    }
}