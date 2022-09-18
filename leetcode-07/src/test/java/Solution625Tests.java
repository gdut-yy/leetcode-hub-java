import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution625Tests {
    private final Solution625 solution625 = new Solution625();

    @Test
    public void example1() {
        int num = 48;
        int expected = 68;
        Assertions.assertEquals(expected, solution625.smallestFactorization(num));
    }

    @Test
    public void example2() {
        int num = 15;
        int expected = 35;
        Assertions.assertEquals(expected, solution625.smallestFactorization(num));
    }
}
