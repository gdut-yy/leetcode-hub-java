import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6168Tests {
    private final Solution6168 solution6168 = new Solution6168();

    @Test
    public void example1() {
        int startPos = 1;
        int endPos = 2;
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution6168.numberOfWays(startPos, endPos, k));
    }

    @Test
    public void example2() {
        int startPos = 2;
        int endPos = 5;
        int k = 10;
        int expected = 0;
        Assertions.assertEquals(expected, solution6168.numberOfWays(startPos, endPos, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/358790165/
        int startPos = 272;
        int endPos = 270;
        int k = 6;
        int expected = 15;
        Assertions.assertEquals(expected, solution6168.numberOfWays(startPos, endPos, k));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/358797698/
        int startPos = 264;
        int endPos = 198;
        int k = 68;
        int expected = 68;
        Assertions.assertEquals(expected, solution6168.numberOfWays(startPos, endPos, k));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/358943474/
        int startPos = 989;
        int endPos = 1000;
        int k = 99;
        int expected = 934081896;
        Assertions.assertEquals(expected, solution6168.numberOfWays(startPos, endPos, k));
    }
}
/*
输入：
989
1000
99
输出：
59
预期结果：
934081896
 */