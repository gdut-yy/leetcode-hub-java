import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6365Tests {
    private final Solution6365 solution6365 = new Solution6365();

    @Test
    public void example1() {
        int n = 4;
        int p = 0;
        int[] banned = {1, 2};
        int k = 4;
        int[] expected = {0, -1, -1, 1};
        Assertions.assertArrayEquals(expected, solution6365.minReverseOperations(n, p, banned, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int p = 0;
        int[] banned = {2, 4};
        int k = 3;
        int[] expected = {0, -1, -1, -1, -1};
        Assertions.assertArrayEquals(expected, solution6365.minReverseOperations(n, p, banned, k));
    }

    @Test
    public void example3() {
        int n = 4;
        int p = 2;
        int[] banned = {0, 1, 3};
        int k = 1;
        int[] expected = {-1, -1, 0, -1};
        Assertions.assertArrayEquals(expected, solution6365.minReverseOperations(n, p, banned, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/420251465/
        // 696 / 710 个通过测试用例 TLE
        String fileName = "solution6365-example4-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int p = UtUtils.loadingInt(fileName, 1);
        int[] banned = UtUtils.loadingInts(fileName, 2);
        int k = UtUtils.loadingInt(fileName, 3);
        int[] expected = UtUtils.loadingInts("solution6365-example4-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution6365.minReverseOperations(n, p, banned, k));
    }
}