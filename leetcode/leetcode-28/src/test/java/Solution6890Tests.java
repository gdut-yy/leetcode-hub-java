import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6890Tests {
    private final Solution6890 solution6890 = new Solution6890();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution6890.findValueOfPartition(nums));
    }

    @Test
    public void example2() {
        int[] nums = {100, 1, 10};
        int expected = 9;
        Assertions.assertEquals(expected, solution6890.findValueOfPartition(nums));
    }
}