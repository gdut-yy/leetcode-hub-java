import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5253Tests {
    private final Solution5253 solution5253 = new Solution5253();

    @Test
    public void example1() {
        int[] queries = {1, 2, 3, 4, 5, 90};
        int intLength = 3;
        long[] expected = {101, 111, 121, 131, 141, 999};
        Assertions.assertArrayEquals(expected, solution5253.kthPalindrome(queries, intLength));
    }

    @Test
    public void example2() {
        int[] queries = {2, 4, 6};
        int intLength = 4;
        long[] expected = {1111, 1331, 1551};
        Assertions.assertArrayEquals(expected, solution5253.kthPalindrome(queries, intLength));
    }
}
