import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0104Tests {
    private final SolutionI0104 solutionI0104 = new SolutionI0104();

    @Test
    public void example1() {
        String s = "tactcoa";
        Assertions.assertTrue(solutionI0104.canPermutePalindrome(s));
    }

    // 补充用例
    @Test
    public void example2() {
        // https://leetcode.cn/problems/palindrome-permutation-lcci/submissions/570606860/
        // 不止小写字母
        String s = "AaBb//a";
        Assertions.assertFalse(solutionI0104.canPermutePalindrome(s));
    }
}
