import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3932Tests {
    private final Solution3932 solution3932 = new Solution3932();

    @Test
    public void example1() {
        int l = 1;
        int r = 9;
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3932.countKthRoots(l, r, k));
    }

    @Test
    public void example2() {
        int l = 8;
        int r = 30;
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3932.countKthRoots(l, r, k));
    }
}