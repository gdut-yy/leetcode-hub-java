import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1163Tests {
    private final Solution1163 solution1163 = new Solution1163();

    @Test
    public void example1() {
        String s = "abab";
        String expected = "bab";
        Assertions.assertEquals(expected, solution1163.lastSubstring(s));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        String expected = "tcode";
        Assertions.assertEquals(expected, solution1163.lastSubstring(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/last-substring-in-lexicographical-order/submissions/590255847/
        String s = "xxbbxxbx";
        String expected = "xxbx";
        Assertions.assertEquals(expected, solution1163.lastSubstring(s));
    }
}