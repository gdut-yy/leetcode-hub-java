import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3752Tests {
    private final Solution3752 solution3752 = new Solution3752();

    @Test
    public void example1() {
        int n = 3;
        long target = 0;
        int[] expected = {-3, 1, 2};
        Assertions.assertArrayEquals(expected, solution3752.lexSmallestNegatedPerm(n, target));
    }

    @Test
    public void example2() {
        int n = 1;
        long target = 10000000000L;
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution3752.lexSmallestNegatedPerm(n, target));
    }
}