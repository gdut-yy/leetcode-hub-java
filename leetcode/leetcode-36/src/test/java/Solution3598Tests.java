import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3598Tests {
    private final Solution3598 solution3598 = new Solution3598();

    @Test
    public void example1() {
        String[] words = {"jump", "run", "run", "jump", "run"};
        int[] expected = {3, 0, 0, 3, 3};
        Assertions.assertArrayEquals(expected, solution3598.longestCommonPrefix(words));
    }

    @Test
    public void example2() {
        String[] words = {"dog", "racer", "car"};
        int[] expected = {0, 0, 0};
        Assertions.assertArrayEquals(expected, solution3598.longestCommonPrefix(words));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/longest-common-prefix-between-adjacent-strings-after-removals/submissions/639893891/
        String[] words = {"cdbff"};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution3598.longestCommonPrefix(words));
    }

    @Test
    public void example4() {
        String[] words = {"cdbff", "cdbff"};
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution3598.longestCommonPrefix(words));
    }
}