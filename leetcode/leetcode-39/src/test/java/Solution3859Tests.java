import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3859Tests {
    private final Solution3859 solution3859 = new Solution3859();

    @Test
    public void example1() {
        int[] num = {1, 2, 1, 2, 2};
        int k = 2;
        int m = 2;
        long expected = 2;
        Assertions.assertEquals(expected, solution3859.countSubarrays(num, k, m));
    }

    @Test
    public void example2() {
        int[] num = {3, 1, 2, 4};
        int k = 2;
        int m = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution3859.countSubarrays(num, k, m));
    }
}