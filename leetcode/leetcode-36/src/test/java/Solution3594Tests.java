import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3594Tests {
    private final Solution3594 solution3594 = new Solution3594();

    @Test
    public void example1() {
        int n = 1;
        int k = 1;
        int m = 2;
        int[] time = {5};
        double[] mul = {1.0, 1.3};
        double expected = 5.00000;
        Assertions.assertEquals(expected, solution3594.minTime(n, k, m, time, mul));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 2;
        int m = 3;
        int[] time = {2, 5, 8};
        double[] mul = {1.0, 1.5, 0.75};
        double expected = 14.50000;
        Assertions.assertEquals(expected, solution3594.minTime(n, k, m, time, mul));
    }

    @Test
    public void example3() {
        int n = 2;
        int k = 1;
        int m = 2;
        int[] time = {10, 10};
        double[] mul = {2.0, 2.0};
        double expected = -1.00000;
        Assertions.assertEquals(expected, solution3594.minTime(n, k, m, time, mul));
    }
}