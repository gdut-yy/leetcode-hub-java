import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4036Tests {
    private final Solution4036 solution4036 = new Solution4036();

    @Test
    public void example1() {
        int[] nums = {2, 5, 7};
        String[] expected = {"b", "ca", "cba"};
        Assertions.assertArrayEquals(expected, solution4036.largestString(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 9, 1};
        String[] expected = {"ba", "da", "a"};
        Assertions.assertArrayEquals(expected, solution4036.largestString(nums));
    }
}