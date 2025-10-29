import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3728Tests {
    private final Solution3728 solution3728 = new Solution3728();

    @Test
    public void example1() {
        int[] capacity = {9, 3, 3, 3, 9};
        long expected = 2;
        Assertions.assertEquals(expected, solution3728.countStableSubarrays(capacity));
    }

    @Test
    public void example2() {
        int[] capacity = {1, 2, 3, 4, 5};
        long expected = 0;
        Assertions.assertEquals(expected, solution3728.countStableSubarrays(capacity));
    }

    @Test
    public void example3() {
        int[] capacity = {-4, 4, 0, 0, -8, -4};
        long expected = 1;
        Assertions.assertEquals(expected, solution3728.countStableSubarrays(capacity));
    }
}