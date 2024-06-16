import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100301Tests {
    private final Solution100301 solution100301 = new Solution100301();

    @Test
    public void example1() {
        int[] hours = {12, 12, 30, 24, 24};
        long expected = 2;
        Assertions.assertEquals(expected, solution100301.countCompleteDayPairs(hours));
    }

    @Test
    public void example2() {
        int[] hours = {72, 48, 24, 3};
        long expected = 3;
        Assertions.assertEquals(expected, solution100301.countCompleteDayPairs(hours));
    }
}