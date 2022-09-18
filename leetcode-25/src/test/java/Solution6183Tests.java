import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6183Tests {
    private final Solution6183 solution6183 = new Solution6183();

    @Test
    public void example1() {
        String[] words = {"abc", "ab", "bc", "b"};
        int[] expected = {5, 4, 3, 2};
        Assertions.assertArrayEquals(expected, solution6183.sumPrefixScores(words));
    }

    @Test
    public void example2() {
        String[] words = {"abcd"};
        int[] expected = {4};
        Assertions.assertArrayEquals(expected, solution6183.sumPrefixScores(words));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/364256777/ TLE
        String[] words = UtUtils.loadingStrings("solution6183-example3-input.txt", 0);
        int[] expected = UtUtils.loadingInts("solution6183-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution6183.sumPrefixScores(words));
    }
}
