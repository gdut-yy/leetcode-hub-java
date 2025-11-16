import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3746Tests {
    private final Solution3746 solution3746 = new Solution3746();

    @Test
    public void example1() {
        String s = "aabbab";
        int expected = 0;
        Assertions.assertEquals(expected, solution3746.minLengthAfterRemovals(s));
    }

    @Test
    public void example2() {
        String s = "aaaa";
        int expected = 4;
        Assertions.assertEquals(expected, solution3746.minLengthAfterRemovals(s));
    }

    @Test
    public void example3() {
        String s = "aaabb";
        int expected = 1;
        Assertions.assertEquals(expected, solution3746.minLengthAfterRemovals(s));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimum-string-length-after-balanced-removals/submissions/678394934/
        String s = "baaab";
        int expected = 1;
        Assertions.assertEquals(expected, solution3746.minLengthAfterRemovals(s));
    }
}