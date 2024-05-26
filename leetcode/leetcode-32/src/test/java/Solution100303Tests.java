import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100303Tests {
    private final Solution100303 solution100303 = new Solution100303();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1, 7};
        int[] queries = {1, 3, 2, 4};
        int x = 1;
        int[] expected = {0, -1, 2, -1};
        Assertions.assertArrayEquals(expected, solution100303.occurrencesOfElement(nums, queries, x));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int[] queries = {10};
        int x = 5;
        int[] expected = {-1};
        Assertions.assertArrayEquals(expected, solution100303.occurrencesOfElement(nums, queries, x));
    }
}