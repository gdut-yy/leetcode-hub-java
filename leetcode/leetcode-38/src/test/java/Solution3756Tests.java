import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3756Tests {
    private final Solution3756 solution3756 = new Solution3756();

    @Test
    public void example1() {
        String s = "10203004";
        int[][] queries = UtUtils.stringToInts2("[[0,7],[1,3],[4,6]]");
        int[] expected = {12340, 4, 9};
        Assertions.assertArrayEquals(expected, solution3756.sumAndMultiply(s, queries));
    }

    @Test
    public void example2() {
        String s = "1000";
        int[][] queries = UtUtils.stringToInts2("[[0,3],[1,1]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution3756.sumAndMultiply(s, queries));
    }

    @Test
    public void example3() {
        String s = "9876543210";
        int[][] queries = UtUtils.stringToInts2("[[0,9]]");
        int[] expected = {444444137};
        Assertions.assertArrayEquals(expected, solution3756.sumAndMultiply(s, queries));
    }
}