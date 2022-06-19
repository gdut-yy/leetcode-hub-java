import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5254Tests {
    private final Solution5254 solution5254 = new Solution5254();

    @Test
    public void example1() {
        int m = 3;
        int n = 5;
        int[][] prices = UtUtils.stringToInts2("[[1,4,2],[2,2,7],[2,1,3]]");
        long expected = 19;
        Assertions.assertEquals(expected, solution5254.sellingWood(m, n, prices));
    }

    @Test
    public void example2() {
        int m = 4;
        int n = 6;
        int[][] prices = UtUtils.stringToInts2("[[3,2,10],[1,4,2],[4,1,3]]");
        long expected = 32;
        Assertions.assertEquals(expected, solution5254.sellingWood(m, n, prices));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/326889007/
        // 爆 int
        String fileName = "solution5254-example3-input.txt";
        int m = UtUtils.loadingInt(fileName, 0);
        int n = UtUtils.loadingInt(fileName, 1);
        int[][] prices = UtUtils.loadingInts2(fileName, 2);
        long expected = 7677640000L;
        Assertions.assertEquals(expected, solution5254.sellingWood(m, n, prices));
    }
}
