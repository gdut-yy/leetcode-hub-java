import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1199Tests {
    private final Solution1199 solution1199 = new Solution1199();

    @Test
    public void example1() {
        int[] blocks = {1};
        int split = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1199.minBuildTime(blocks, split));
    }

    @Test
    public void example2() {
        int[] blocks = {1, 2};
        int split = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solution1199.minBuildTime(blocks, split));
    }

    @Test
    public void example3() {
        int[] blocks = {1, 2, 3};
        int split = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution1199.minBuildTime(blocks, split));
    }
}