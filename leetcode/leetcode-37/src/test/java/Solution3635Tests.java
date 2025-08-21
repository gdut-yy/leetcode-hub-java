import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3635Tests {
    private final Solution3635 solution3635 = new Solution3635();

    @Test
    public void example1() {
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        int expected = 9;
        Assertions.assertEquals(expected, solution3635.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    @Test
    public void example2() {
        int[] landStartTime = {5};
        int[] landDuration = {3};
        int[] waterStartTime = {1};
        int[] waterDuration = {10};
        int expected = 14;
        Assertions.assertEquals(expected, solution3635.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}