import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3693Tests {
    private final Solution3693 solution3693 = new Solution3693();

    @Test
    public void example1() {
        int n = 4;
        int[] costs = {1, 2, 3, 4};
        int expected = 13;
        Assertions.assertEquals(expected, solution3693.climbStairs(n, costs));
    }

    @Test
    public void example2() {
        int n = 4;
        int[] costs = {5, 1, 6, 2};
        int expected = 11;
        Assertions.assertEquals(expected, solution3693.climbStairs(n, costs));
    }

    @Test
    public void example3() {
        int n = 3;
        int[] costs = {9, 8, 3};
        int expected = 12;
        Assertions.assertEquals(expected, solution3693.climbStairs(n, costs));
    }
}