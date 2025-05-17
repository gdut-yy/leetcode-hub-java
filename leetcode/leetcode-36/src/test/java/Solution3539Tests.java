import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3539Tests {
    private final Solution3539 solution3539 = new Solution3539();

    @Test
    public void example1() {
        int m = 5;
        int k = 5;
        int[] nums = {1, 10, 100, 10000, 1000000};
        int expected = 991600007;
        Assertions.assertEquals(expected, solution3539.magicalSum(m, k, nums));
    }

    @Test
    public void example2() {
        int m = 2;
        int k = 2;
        int[] nums = {5, 4, 3, 2, 1};
        int expected = 170;
        Assertions.assertEquals(expected, solution3539.magicalSum(m, k, nums));
    }

    @Test
    public void example3() {
        int m = 1;
        int k = 1;
        int[] nums = {28};
        int expected = 28;
        Assertions.assertEquals(expected, solution3539.magicalSum(m, k, nums));
    }
}