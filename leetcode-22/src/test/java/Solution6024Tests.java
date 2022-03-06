import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6024Tests {
    private final Solution6024 solution6024 = new Solution6024();

    @Test
    public void example1() {
        int[] nums = {1, 100, 200, 1, 100};
        int key = 1;
        int expected = 100;
        Assertions.assertEquals(expected, solution6024.mostFrequent(nums, key));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 3};
        int key = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution6024.mostFrequent(nums, key));
    }
}
