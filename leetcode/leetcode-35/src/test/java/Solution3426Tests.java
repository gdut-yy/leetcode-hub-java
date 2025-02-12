import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3426Tests {
    private final Solution3426 solution3426 = new Solution3426();

    @Test
    public void example1() {
        int m = 2;
        int n = 2;
        int k = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solution3426.distanceSum(m, n, k));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 4;
        int k = 3;
        int expected = 20;
        Assertions.assertEquals(expected, solution3426.distanceSum(m, n, k));
    }
}