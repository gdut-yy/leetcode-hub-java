import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3440Tests {
    private final Solution3440 solution3440 = new Solution3440();

    @Test
    public void example1() {
        int eventTime = 5;
        int[] startTime = {1, 3};
        int[] endTime = {2, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3440.maxFreeTime(eventTime, startTime, endTime));
    }

    @Test
    public void example2() {
        int eventTime = 10;
        int[] startTime = {0, 7, 9};
        int[] endTime = {1, 8, 10};
        int expected = 7;
        Assertions.assertEquals(expected, solution3440.maxFreeTime(eventTime, startTime, endTime));
    }

    @Test
    public void example3() {
        int eventTime = 10;
        int[] startTime = {0, 3, 7, 9};
        int[] endTime = {1, 4, 8, 10};
        int expected = 6;
        Assertions.assertEquals(expected, solution3440.maxFreeTime(eventTime, startTime, endTime));
    }
}