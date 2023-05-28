import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2403Tests {
    private final Solution2403 solution2403 = new Solution2403();

    @Test
    public void example1() {
        int[] power = {3, 1, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2403.minimumTime(power));
    }

    @Test
    public void example2() {
        int[] power = {1, 1, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2403.minimumTime(power));
    }

    @Test
    public void example3() {
        int[] power = {1, 2, 4, 9};
        int expected = 6;
        Assertions.assertEquals(expected, solution2403.minimumTime(power));
    }
}