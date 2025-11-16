import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3733Tests {
    private final Solution3733 solution3733 = new Solution3733();

    @Test
    public void example1() {
        int[] d = {3, 1};
        int[] r = {2, 3};
        long expected = 5;
        Assertions.assertEquals(expected, solution3733.minimumTime(d, r));
    }

    @Test
    public void example2() {
        int[] d = {1, 3};
        int[] r = {2, 2};
        long expected = 7;
        Assertions.assertEquals(expected, solution3733.minimumTime(d, r));
    }

    @Test
    public void example3() {
        int[] d = {2, 1};
        int[] r = {3, 4};
        long expected = 3;
        Assertions.assertEquals(expected, solution3733.minimumTime(d, r));
    }
}