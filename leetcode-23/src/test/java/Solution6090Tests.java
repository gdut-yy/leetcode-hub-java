import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6090Tests {
    private final Solution6090 solution6090 = new Solution6090();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution6090.minMaxGame(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3};
        int expected = 3;
        Assertions.assertEquals(expected, solution6090.minMaxGame(nums));
    }
}
