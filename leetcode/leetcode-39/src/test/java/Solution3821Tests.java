import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3821Tests {
    private final Solution3821 solution3821 = new Solution3821();

    @Test
    public void example1() {
        long n = 4;
        int k = 2;
        long expected = 9;
        Assertions.assertEquals(expected, solution3821.nthSmallest(n, k));
    }

    @Test
    public void example2() {
        long n = 3;
        int k = 1;
        long expected = 4;
        Assertions.assertEquals(expected, solution3821.nthSmallest(n, k));
    }
}