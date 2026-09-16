import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3986Tests {
    private final Solution3986 solution3986 = new Solution3986();

    @Test
    public void example1() {
        String startTime = "01:00:00";
        String endTime = "01:00:25";
        int expected = 25;
        Assertions.assertEquals(expected, solution3986.secondsBetweenTimes(startTime, endTime));
    }

    @Test
    public void example2() {
        String startTime = "12:34:56";
        String endTime = "13:00:00";
        int expected = 1504;
        Assertions.assertEquals(expected, solution3986.secondsBetweenTimes(startTime, endTime));
    }
}