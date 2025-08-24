import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3648Tests {
    private final Solution3648 solution3648 = new Solution3648();

    @Test
    public void example1() {
        int n = 5;
        int m = 5;
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3648.minSensors(n, m, k));
    }

    @Test
    public void example2() {
        int n = 2;
        int m = 2;
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3648.minSensors(n, m, k));
    }
}