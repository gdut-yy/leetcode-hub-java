import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3621Tests {
    private final Solution3621 solution3621 = new Solution3621();

    @Test
    public void example1() {
        long n = 4;
        int k = 1;
        long expected = 2;
        Assertions.assertEquals(expected, solution3621.popcountDepth(n, k));
    }

    @Test
    public void example2() {
        long n = 7;
        int k = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution3621.popcountDepth(n, k));
    }
}