import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3784Tests {
    private final Solution3784 solution3784 = new Solution3784();

    @Test
    public void example1() {
        String s = "aabaac";
        int[] cost = {1, 2, 3, 4, 1, 10};
        long expected = 11;
        Assertions.assertEquals(expected, solution3784.minCost(s, cost));
    }

    @Test
    public void example2() {
        String s = "abc";
        int[] cost = {10, 5, 8};
        long expected = 13;
        Assertions.assertEquals(expected, solution3784.minCost(s, cost));
    }

    @Test
    public void example3() {
        String s = "zzzzz";
        int[] cost = {67, 67, 67, 67, 67};
        long expected = 0;
        Assertions.assertEquals(expected, solution3784.minCost(s, cost));
    }
}