import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3439Tests {
    private final Solution3439 solution3439 = new Solution3439();

    @Test
    public void example1() {
        int eventTime = 5;
        int k = 1;
        int[] startTime = {1, 3};
        int[] endTime = {2, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3439.maxFreeTime(eventTime, k, startTime, endTime));
    }

    @Test
    public void example2() {
        int eventTime = 10;
        int k = 1;
        int[] startTime = {0, 2, 9};
        int[] endTime = {1, 4, 10};
        int expected = 6;
        Assertions.assertEquals(expected, solution3439.maxFreeTime(eventTime, k, startTime, endTime));
    }

    @Test
    public void example3() {
        int eventTime = 5;
        int k = 2;
        int[] startTime = {0, 1, 2, 3, 4};
        int[] endTime = {1, 2, 3, 4, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution3439.maxFreeTime(eventTime, k, startTime, endTime));
    }
}