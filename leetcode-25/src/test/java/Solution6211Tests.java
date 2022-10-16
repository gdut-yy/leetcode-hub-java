import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6211Tests {
    private final Solution6211 solution6211 = new Solution6211();

    @Test
    public void example1() {
        int[] nums = {6, 2, 2, 2, 6};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution6211.componentValue(nums, edges));
    }

    @Test
    public void example2() {
        int[] nums = {2};
        int[][] edges = UtUtils.stringToInts2("[]");
        int expected = 0;
        Assertions.assertEquals(expected, solution6211.componentValue(nums, edges));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {1, 2, 1, 1, 1};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,3],[3,4],[4,2]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution6211.componentValue(nums, edges));
    }
}
/*
输入：
[1,2,1,1,1]
[[0,1],[1,3],[3,4],[4,2]]
输出：
2
预期结果：
1
 */