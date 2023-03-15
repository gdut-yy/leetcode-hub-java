import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution629Tests {
    private final Solution629 solution629 = new Solution629();

    @Test
    public void example1() {
        int n = 3;
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution629.kInversePairs(n, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution629.kInversePairs(n, k));
    }
}