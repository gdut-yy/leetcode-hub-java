import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3814Tests {
    private final Solution3814 solution3814 = new Solution3814();

    @Test
    public void example1() {
        int[] costs = {4, 8, 5, 3};
        int[] capacity = {1, 5, 2, 7};
        int budget = 8;
        int expected = 8;
        Assertions.assertEquals(expected, solution3814.maxCapacity(costs, capacity, budget));
    }

    @Test
    public void example2() {
        int[] costs = {3, 5, 7, 4};
        int[] capacity = {2, 4, 3, 6};
        int budget = 7;
        int expected = 6;
        Assertions.assertEquals(expected, solution3814.maxCapacity(costs, capacity, budget));
    }

    @Test
    public void example3() {
        int[] costs = {2, 2, 2};
        int[] capacity = {3, 5, 4};
        int budget = 5;
        int expected = 9;
        Assertions.assertEquals(expected, solution3814.maxCapacity(costs, capacity, budget));
    }
}