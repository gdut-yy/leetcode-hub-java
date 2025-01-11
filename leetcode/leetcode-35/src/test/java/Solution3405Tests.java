import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3405Tests {
    private final Solution3405 solution3405 = new Solution3405();

    @Test
    public void example1() {
        int n = 3;
        int m = 2;
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3405.countGoodArrays(n, m, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int m = 2;
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution3405.countGoodArrays(n, m, k));
    }

    @Test
    public void example3() {
        int n = 5;
        int m = 2;
        int k = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution3405.countGoodArrays(n, m, k));
    }
}