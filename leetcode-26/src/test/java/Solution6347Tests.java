import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6347Tests {
    private final Solution6347 solution6347 = new Solution6347();

    @Test
    public void example1() {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[1,4],[1,1]]");
        int[] expected = {2, 3, 0};
        Assertions.assertArrayEquals(expected, solution6347.vowelStrings(words, queries));
    }

    @Test
    public void example2() {
        String[] words = {"a", "e", "i"};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[0,1],[2,2]]");
        int[] expected = {3, 2, 1};
        Assertions.assertArrayEquals(expected, solution6347.vowelStrings(words, queries));
    }
}