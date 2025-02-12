import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3424Tests {
    private final Solution3424 solution3424 = new Solution3424();

    @Test
    public void example1() {
        int[] arr = {-7, 9, 5};
        int[] brr = {7, -2, -5};
        long k = 2;
        long expected = 13;
        Assertions.assertEquals(expected, solution3424.minCost(arr, brr, k));
    }

    @Test
    public void example2() {
        int[] arr = {2, 1};
        int[] brr = {2, 1};
        long k = 0;
        long expected = 0;
        Assertions.assertEquals(expected, solution3424.minCost(arr, brr, k));
    }
}