import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3731Tests {
    private final Solution3731 solution3731 = new Solution3731();

    @Test
    public void example1() {
        int[] nums = {1, 4, 2, 5};
        List<Integer> expected = List.of(3);
        Assertions.assertEquals(expected, solution3731.findMissingElements(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 8, 6, 9};
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution3731.findMissingElements(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 1};
        List<Integer> expected = List.of(2, 3, 4);
        Assertions.assertEquals(expected, solution3731.findMissingElements(nums));
    }
}