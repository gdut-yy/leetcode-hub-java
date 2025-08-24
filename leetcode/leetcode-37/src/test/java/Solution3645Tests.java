import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3645Tests {
    private final Solution3645 solution3645 = new Solution3645();

    @Test
    public void example1() {
        int[] value = {3, 5, 8};
        int[] limit = {2, 1, 3};
        long expected = 16;
        Assertions.assertEquals(expected, solution3645.maxTotal(value, limit));
    }

    @Test
    public void example2() {
        int[] value = {4, 2, 6};
        int[] limit = {1, 1, 1};
        long expected = 6;
        Assertions.assertEquals(expected, solution3645.maxTotal(value, limit));
    }

    @Test
    public void example3() {
        int[] value = {4, 1, 5, 2};
        int[] limit = {3, 3, 2, 3};
        long expected = 12;
        Assertions.assertEquals(expected, solution3645.maxTotal(value, limit));
    }
}