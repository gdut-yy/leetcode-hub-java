import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6285Tests {
    private final Solution6285 solution6285 = new Solution6285();

    @Test
    public void example1() {
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        long expected = 50;
        Assertions.assertEquals(expected, solution6285.maxKelements(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        long expected = 17;
        Assertions.assertEquals(expected, solution6285.maxKelements(nums, k));
    }
}
