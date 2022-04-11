import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Solution2234Tests {
    private final Solution2234 solution2234 = new Solution2234();

    @Test
    public void example1() {
        int[] flowers = {1, 3, 1, 1};
        long newFlowers = 7;
        int target = 6;
        int full = 12;
        int partial = 1;
        long expected = 14;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    public void example2() {
        int[] flowers = {2, 4, 5, 3};
        long newFlowers = 10;
        int target = 5;
        int full = 2;
        int partial = 6;
        long expected = 30;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] flowers = {18, 16, 10, 10, 5};
        long newFlowers = 10;
        int target = 3;
        int full = 15;
        int partial = 4;
        long expected = 75;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    public void example4() {
        int[] flowers = {5, 5, 15, 1, 9};
        long newFlowers = 36;
        int target = 12;
        int full = 9;
        int partial = 2;
        long expected = 58;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    @Disabled
    public void example5() {
        String fileName = "solution2234-example5-input.txt";
        int[] flowers = UtUtils.loadingInts(fileName, 0);
        long newFlowers = UtUtils.loadingLong(fileName, 1);
        int target = UtUtils.loadingInt(fileName, 2);
        int full = UtUtils.loadingInt(fileName, 3);
        int partial = UtUtils.loadingInt(fileName, 4);
        long expected = 4527585163L;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }
}
/*
输入：
[18,16,10,10,5]
10
3
15
4
输出：
0
预期：
75

输入：
[5,5,15,1,9]
36
12
9
2
输出：
50
预期：
58
 */

