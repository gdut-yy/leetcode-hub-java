import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3971Tests {
    private final Solution3971 solution39771 = new Solution3971();

    @Test
    public void example1() {
        int[] value = {6, 5, 4};
        int[] decay = {2, 1, 1};
        int m = 4;
        int expected = 19;
        Assertions.assertEquals(expected, solution39771.maxTotalValue(value, decay, m));
    }

    @Test
    public void example2() {
        int[] value = {7, 2, 2};
        int[] decay = {3, 2, 1};
        int m = 2;
        int expected = 11;
        Assertions.assertEquals(expected, solution39771.maxTotalValue(value, decay, m));
    }

    @Test
    public void example3() {
        int[] value = {4, 3};
        int[] decay = {5, 4};
        int m = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solution39771.maxTotalValue(value, decay, m));
    }
}