import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6049Tests {
    private final Solution6049 solution6049 = new Solution6049();

    @Test
    public void example1() {
        int[] edges = {1, 0, 0, 0, 0, 7, 7, 5};
        int expected = 7;
        Assertions.assertEquals(expected, solution6049.edgeScore(edges));
    }

    @Test
    public void example2() {
        int[] edges = {2, 0, 0, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution6049.edgeScore(edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/349932870/
        // 爆 int
        int[] edges = UtUtils.loadingInts("solution6049-example3-input.txt", 0);
        int expected = 1;
        Assertions.assertEquals(expected, solution6049.edgeScore(edges));
    }
}
