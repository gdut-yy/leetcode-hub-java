import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3407Tests {
    private final Solution3407 solution3407 = new Solution3407();

    @Test
    public void example1() {
        String s = "leetcode";
        String p = "ee*e";
        Assertions.assertTrue(solution3407.hasMatch(s, p));
    }

    @Test
    public void example2() {
        String s = "car";
        String p = "c*v";
        Assertions.assertFalse(solution3407.hasMatch(s, p));
    }

    @Test
    public void example3() {
        String s = "luck";
        String p = "u*";
        Assertions.assertTrue(solution3407.hasMatch(s, p));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/substring-matching-pattern/submissions/591137781/
        String s = "l";
        String p = "*";
        Assertions.assertTrue(solution3407.hasMatch(s, p));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/problems/substring-matching-pattern/submissions/591138370/
        String s = "hccc";
        String p = "m*c";
        Assertions.assertFalse(solution3407.hasMatch(s, p));
    }
}