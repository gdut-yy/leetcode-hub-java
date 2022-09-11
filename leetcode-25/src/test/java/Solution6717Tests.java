import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6717Tests {
    private final Solution6717 solution6717 = new Solution6717();

    @Test
    public void example1() {
        String s = "abacaba";
        int expected = 4;
        Assertions.assertEquals(expected, solution6717.partitionString(s));
    }

    @Test
    public void example2() {
        String s = "ssssss";
        int expected = 6;
        Assertions.assertEquals(expected, solution6717.partitionString(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/361521246/
        String s = "hdklqkcssgxlvehva";
        int expected = 4;
        Assertions.assertEquals(expected, solution6717.partitionString(s));
    }
}
