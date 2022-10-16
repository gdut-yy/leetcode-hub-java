import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6209Tests {
    private final Solution6209 solution6209 = new Solution6209();

    @Test
    public void example1() {
        int n = 15;
        int[][] queries = UtUtils.stringToInts2("[[0,1],[2,2],[0,3]]");
        int[] expected = {2, 4, 64};
        Assertions.assertArrayEquals(expected, solution6209.productQueries(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries2(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries3(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries4(n, queries));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,0]]");
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solution6209.productQueries(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries2(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries3(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries4(n, queries));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/373546473/ 边界测试
        int n = UtUtils.loadingInt("solution6209-example3-input.txt", 0);
        int[][] queries = UtUtils.loadingInts2("solution6209-example3-input.txt", 1);
        int[] expected = UtUtils.loadingInts("solution6209-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution6209.productQueries(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries2(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries3(n, queries));
        Assertions.assertArrayEquals(expected, solution6209.productQueries4(n, queries));
    }
}
