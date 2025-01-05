import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3377Tests {
    private final Solution3377 solution3377 = new Solution3377();

    @Test
    public void example1() {
        int n = 10;
        int m = 12;
        int expected = 85;
        Assertions.assertEquals(expected, solution3377.minOperations(n, m));
    }

    @Test
    public void example2() {
        int n = 4;
        int m = 8;
        int expected = -1;
        Assertions.assertEquals(expected, solution3377.minOperations(n, m));
    }

    @Test
    public void example3() {
        int n = 6;
        int m = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution3377.minOperations(n, m));
    }
}