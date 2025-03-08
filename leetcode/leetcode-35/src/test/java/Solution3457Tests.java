import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3457Tests {
    private final Solution3457 solution3457 = new Solution3457();

    @Test
    public void example1() {
        int[] pizzas = {1, 2, 3, 4, 5, 6, 7, 8};
        long expected = 14;
        Assertions.assertEquals(expected, solution3457.maxWeight(pizzas));
    }

    @Test
    public void example2() {
        int[] pizzas = {2, 1, 1, 1, 1, 1, 1, 1};
        long expected = 3;
        Assertions.assertEquals(expected, solution3457.maxWeight(pizzas));
    }
}