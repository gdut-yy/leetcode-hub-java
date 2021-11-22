import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1065Tests {
    private final Solution1065 solution1065 = new Solution1065();

    @Test
    public void example1() {
        String text = "thestoryofleetcodeandme";
        String[] words = {"story", "fleet", "leetcode"};
        int[][] expected = {{3, 7}, {9, 13}, {10, 17}};
        Assertions.assertArrayEquals(expected, solution1065.indexPairs(text, words));
    }

    @Test
    public void example2() {
        String text = "ababa";
        String[] words = {"aba", "ab"};
        int[][] expected = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        Assertions.assertArrayEquals(expected, solution1065.indexPairs(text, words));
    }
}
