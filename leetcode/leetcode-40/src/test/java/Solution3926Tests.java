import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3926Tests {
    private final Solution3926 solution3926 = new Solution3926();

    @Test
    public void example1() {
        String[] chunks = {"hello wor", "ld hello"};
        String[] queries = {"hello", "world", "wor"};
        int[] expected = {2, 1, 0};
        Assertions.assertArrayEquals(expected, solution3926.countWordOccurrences(chunks, queries));
    }

    @Test
    public void example2() {
        String[] chunks = {"a--b a-", "-c"};
        String[] queries = {"a", "b", "c"};
        int[] expected = {2, 1, 1};
        Assertions.assertArrayEquals(expected, solution3926.countWordOccurrences(chunks, queries));
    }

    @Test
    public void example3() {
        String[] chunks = {"hello"};
        String[] queries = {"hello", "ell"};
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution3926.countWordOccurrences(chunks, queries));
    }
}