import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100266Tests {
    private final Solution100266 solution100266 = new Solution100266();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 1};
        long expected = 5;
        Assertions.assertEquals(expected, solution100266.countAlternatingSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 1, 0};
        long expected = 10;
        Assertions.assertEquals(expected, solution100266.countAlternatingSubarrays(nums));
    }
}