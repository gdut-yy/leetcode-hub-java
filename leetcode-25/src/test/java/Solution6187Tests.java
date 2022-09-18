import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6187Tests {
    private final Solution6187 solution6187 = new Solution6187();

    @Test
    public void example1() {
        int[][] transactions = UtUtils.stringToInts2("[[2,1],[5,0],[4,2]]");
        long expected = 10;
        Assertions.assertEquals(expected, solution6187.minimumMoney(transactions));
    }

    @Test
    public void example2() {
        int[][] transactions = UtUtils.stringToInts2("[[3,0],[0,3]]");
        long expected = 3;
        Assertions.assertEquals(expected, solution6187.minimumMoney(transactions));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/364137278/
        int[][] transactions = UtUtils.stringToInts2("[[3,9],[0,4],[7,10],[3,5],[0,9],[9,3],[7,4],[0,0],[3,3],[8,0]]");
        long expected = 24;
        Assertions.assertEquals(expected, solution6187.minimumMoney(transactions));
    }
}
